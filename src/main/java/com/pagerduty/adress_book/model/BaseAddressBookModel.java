package com.pagerduty.adress_book.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BaseAddressBookModel {

	@JsonProperty("id")
	protected String id;
	@JsonProperty("type")
	protected String type;
	@JsonProperty("summary")
	protected String summary;
	@JsonProperty("self")
	protected String self;
	@JsonProperty("html_url")
	protected String htmlUrl;

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getSummary() {
		return summary;
	}

	public String getSelf() {
		return self;
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

}
