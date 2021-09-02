package com.pagerduty.adress_book.request;

import java.util.List;

import com.pagerduty.adress_book.model.ItemType;

public class GetUserDetailRequest extends PaginatedRequest {

	private String query;
	private List<String> teamIds;
	private List<ItemType> includes;

	public GetUserDetailRequest(Integer limit, Integer offset, boolean total, String query, List<String> teamIds,
			List<ItemType> includes) {
		super(limit, offset, total);
		this.query = query;
		this.teamIds = teamIds;
		this.includes = includes;
	}

	public String getQuery() {
		return query;
	}

	public List<String> getTeamIds() {
		return teamIds;
	}

	public List<ItemType> getIncludes() {
		return includes;
	}
}
