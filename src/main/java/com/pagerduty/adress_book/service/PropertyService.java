package com.pagerduty.adress_book.service;

import java.util.Properties;

import com.pagerduty.adress_book.utilities.PropertyLoader;

/**
 * 
 * creating property service as right now property are coming from local file
 * system, in future they can be from another property service, database or
 * other sources
 * 
 * @author abhay.gupta
 *
 */
class PropertyService {

	private final static Properties properties = new PropertyLoader().load();

	public String get(String propKey) {
		if (propKey == null || propKey.isEmpty())
			return null;
		return getProperties().getProperty(propKey);
	}

	public int getInt(String propKey) {
		String value = get(propKey);
		return Integer.parseInt(value);
	}

	public Boolean getBoolean(String propKey) {
		String value = get(propKey);
		return Boolean.valueOf(value);
	}

	static Properties getProperties() {
		return properties;
	}
}
