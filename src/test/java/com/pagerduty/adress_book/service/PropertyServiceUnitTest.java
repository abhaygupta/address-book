package com.pagerduty.adress_book.service;

import static org.mockito.Mockito.when;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import org.powermock.api.mockito.PowerMockito;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PropertyService.class)
public class PropertyServiceUnitTest {

	private static final Properties properties = new Properties();
	static {
		properties.put("string-test", "test");
		properties.put("boolean-test", false);
		properties.put("num-test", "123");

	}

	@Test
	public void testGetProperties() {
		PowerMockito.mockStatic(PropertyService.class);
		PropertyService service = new PropertyService();

		when(PropertyService.getProperties()).thenReturn(properties);
		Assert.assertEquals("test", service.get("string-test"));
		Assert.assertEquals(false, service.getBoolean("boolean-test"));
		Assert.assertEquals(123, service.getInt("num-test"));

		PowerMockito.verifyStatic();
	}

}
