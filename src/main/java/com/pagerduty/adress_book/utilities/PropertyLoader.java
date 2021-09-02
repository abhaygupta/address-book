package com.pagerduty.adress_book.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyLoader {

	private static final String APPLICATION_PROPERTIES = "application.properties";
	private static final Logger LOGGER = Logger.getLogger("PropertyLoader");

	public Properties load() {
		Properties properties = new Properties();
		InputStream inputStream = null;
		URL resource = getClass().getClassLoader().getResource(APPLICATION_PROPERTIES);
		File propertyFile;
		try {
			propertyFile = new File(resource.toURI());
			inputStream = new FileInputStream(propertyFile);
			properties.load(inputStream);
		} catch (URISyntaxException ex) {
			LOGGER.log(Level.SEVERE, "Invalid property file path=" + APPLICATION_PROPERTIES, ex);
		} catch (IOException ex) {
			LOGGER.log(Level.SEVERE, "Failed loading properties from file=" + APPLICATION_PROPERTIES, ex);
		} finally {
			if (inputStream != null)
				try {
					inputStream.close();
				} catch (IOException ex) {
					LOGGER.log(Level.SEVERE, "Failed closing InputStream from file=" + APPLICATION_PROPERTIES, ex);
				}
		}
		return properties;
	}
}
