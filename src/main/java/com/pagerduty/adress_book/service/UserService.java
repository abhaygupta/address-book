package com.pagerduty.adress_book.service;

import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.util.UriBuilder;

import com.pagerduty.adress_book.model.Users;
import com.pagerduty.adress_book.request.GetUserDetailRequest;
import com.pagerduty.adress_book.request.ListUserRequest;

import reactor.core.publisher.Mono;

public class UserService {

	private static final String QUERY = "query";
	private static final String COMMA_DELIM = ",";
	private static final String TOTAL = "total";
	private static final String ACCEPT_HEADER_VERSION = "application/vnd.pagerduty+json;version=2";
	private static final String LIST_USER_API = "/users";
	private static final String OFFSET = "offset";
	private static final String PAGER_DUTY_RECORD_LIMIT = "pagerDuty.recordLimit";
	private static final String LIMIT = "limit";
	private static final String TOKEN_PREFIX = "Token token=";
	private static final String APPLICATION_JSON = "application/json";
	private static final String PAGER_DUTY_TEST_API_TOKEN = "pagerDuty.testApiToken";
	private static final String PAGER_DUTY_SERVICE_BASE_URL = "pagerDuty.baseURL";
	private static final String TEAM_IDS = "team_ids[]";
	private static final String INCLUDE = "include[]";

	private static final PropertyService propertyService = new PropertyService();

	// can use connection pool here - WebClient is immutable and threadsafe
	private static final WebClient pagerDutyClient = WebClient.builder()
			.baseUrl(propertyService.get(PAGER_DUTY_SERVICE_BASE_URL))
			.defaultHeader(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON)
			.defaultHeader(HttpHeaders.AUTHORIZATION, TOKEN_PREFIX + propertyService.get(PAGER_DUTY_TEST_API_TOKEN))
			.defaultHeader(HttpHeaders.ACCEPT, ACCEPT_HEADER_VERSION).build();

	public Users list(final ListUserRequest request) {
		Mono<Users> users = buildListSpec(request).retrieve().bodyToMono(Users.class);
		return users.block();
	}

	public Users getDetails(final GetUserDetailRequest request) {
		Mono<Users> users = buildGetDetailsRequest(request).retrieve().bodyToMono(Users.class);
		return users.block();
	}

	@SuppressWarnings("rawtypes")
	RequestHeadersSpec buildListSpec(final ListUserRequest request) {
		int limit = request == null ? propertyService.getInt(PAGER_DUTY_RECORD_LIMIT) : request.getLimit();
		int offset = request == null ? 0 : request.getOffset();
		boolean total = request == null ? false : request.hasTotal();

		return pagerDutyClient.get().uri(uriBuilder -> {
			return uriBuilder.path(LIST_USER_API).queryParam(LIMIT, limit).queryParam(OFFSET, offset)
					.queryParam(TOTAL, total).build();
		});
	}

	@SuppressWarnings("rawtypes")
	RequestHeadersSpec buildGetDetailsRequest(final GetUserDetailRequest request) {
		int limit = request == null ? propertyService.getInt(PAGER_DUTY_RECORD_LIMIT) : request.getLimit();
		int offset = request == null ? 0 : request.getOffset();
		boolean total = request == null ? false : request.hasTotal();

		return pagerDutyClient.get().uri(uriBuilder -> {
			UriBuilder spec = uriBuilder.path(LIST_USER_API).queryParam(LIMIT, limit).queryParam(OFFSET, offset)
					.queryParam(TOTAL, total);

			// if a query is specified
			if (request.getQuery() != null && !request.getQuery().isEmpty())
				spec.queryParam(QUERY, request.getQuery());

			// if any teams are specified
			if (request.getTeamIds() != null && !request.getTeamIds().isEmpty())
				spec.queryParam(TEAM_IDS, String.join(COMMA_DELIM, request.getTeamIds()));

			// if any inclusions are specified
			if (request.getIncludes() != null && !request.getIncludes().isEmpty())
				spec.queryParam(INCLUDE, request.getIncludes().stream().map(incl -> incl.getLiteral())
						.collect(Collectors.joining(COMMA_DELIM)));

			return spec.build();
		});
	}

}
