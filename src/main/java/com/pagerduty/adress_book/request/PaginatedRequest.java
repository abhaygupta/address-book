package com.pagerduty.adress_book.request;

public abstract class PaginatedRequest {

	protected Integer limit;
	protected Integer offset;
	protected boolean total;

	public PaginatedRequest(Integer limit, Integer offset, boolean total) {
		super();
		this.limit = limit;
		this.offset = offset;
		this.total = total;
	}

	public Integer getLimit() {
		return limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public boolean hasTotal() {
		return total;
	}
}
