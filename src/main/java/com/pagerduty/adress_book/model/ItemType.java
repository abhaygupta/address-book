package com.pagerduty.adress_book.model;

public enum ItemType {

	ContactMethods("contact_methods"),
	NotificationRules("notification_rules"),
	Teams("teams"),
	Subdomains("subdomains");
	
	private String literal;
	
	private ItemType(String literal) {
		this.literal = literal;
	}
	
	public String getLiteral() {
		return literal;
	}

}
