package com.pagerduty.adress_book.service.it;

import java.util.Collections;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.pagerduty.adress_book.model.ItemType;
import com.pagerduty.adress_book.model.Users;
import com.pagerduty.adress_book.request.GetUserDetailRequest;
import com.pagerduty.adress_book.request.ListUserRequest;
import com.pagerduty.adress_book.service.UserService;

public class UserServiceIntegrationTest {

	private static final UserService service = new UserService();
	private static final Logger LOGGER = Logger.getGlobal();
	private static final Gson JSON = new Gson();

	@Test
	public void testListUserWithNullPaginationContext() {
		Users users = service.list(null);
		Assert.assertNotNull(users);
		Assert.assertNotNull(users.getUsers());
		Assert.assertFalse(users.getUsers().isEmpty());
		// bad practice - just for demo
		LOGGER.info("List Users - null request= " + JSON.toJson(users) + "\n");

	}

	@Test
	public void testListUserWithPaginationContext() {
		Users users = service.list(new ListUserRequest(10, 0));
		Assert.assertNotNull(users);
		Assert.assertNotNull(users.getUsers());
		Assert.assertFalse(users.getUsers().isEmpty());
		Assert.assertEquals(10, users.getUsers().size());
	}

	@Test
	public void testGetUserDetailsForAlan() {
		String query = "Alan";
		Users users = service.getDetails(new GetUserDetailRequest(10, 0, false, query, null, null));
		Assert.assertNotNull(users);
		Assert.assertNotNull(users.getUsers());
		Assert.assertEquals(1, users.getUsers().size());
		Assert.assertTrue(users.getUsers().get(0).getName().contains(query));
		// bad practice - just for demo
		LOGGER.info("Get Users Details for query=Alan " + JSON.toJson(users) + "\n");
	}

	@Test
	public void testGetUserDetailsForAlanWithNotificationRules() {
		String query = "Alan";
		Users users = service.getDetails(new GetUserDetailRequest(10, 0, false, query, null,
				Collections.singletonList(ItemType.NotificationRules)));
		Assert.assertNotNull(users);
		Assert.assertNotNull(users.getUsers());
		Assert.assertEquals(1, users.getUsers().size());
		Assert.assertTrue(users.getUsers().get(0).getName().contains(query));
		Assert.assertNotNull(users.getUsers().get(0).getNotificationRules());
		Assert.assertFalse(users.getUsers().get(0).getNotificationRules().isEmpty());
	}
}
