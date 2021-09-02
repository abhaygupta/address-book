package com.pagerduty.adress_book.request;

public class ListUserRequest extends PaginatedRequest {

	public ListUserRequest(Integer limit, Integer offset) {
		super(limit, offset, true);
	}
}
