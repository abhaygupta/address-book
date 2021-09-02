package com.pagerduty.adress_book.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Users {

	@JsonProperty("users")
	private List<User> users;

	@JsonProperty("limit")
	private Integer limit;

	@JsonProperty("offset")
	private Integer offset;

	@JsonProperty("total")
	private Integer total;

	@JsonProperty("more")
	private boolean more;

	public List<User> getUsers() {
		return users;
	}

	public Integer getLimit() {
		return limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public Integer getTotal() {
		return total;
	}

	public boolean hasMore() {
		return more;
	}
}
