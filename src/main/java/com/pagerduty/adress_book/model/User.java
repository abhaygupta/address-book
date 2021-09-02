package com.pagerduty.adress_book.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User extends BaseAddressBookModel {

	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;
	@JsonProperty("time_zone")
	private String timeZone;
	@JsonProperty("color")
	private String color;
	@JsonProperty("avatar_url")
	private String avatarUrl;
	@JsonProperty("billed")
	private boolean billed;
	@JsonProperty("role")
	private String role;
	@JsonProperty("description")
	private String description;
	@JsonProperty("invitation_sent")
	private boolean invitationSent;
	@JsonProperty("job_title")
	private String jobTitle;
	@JsonProperty("teams")
	private List<Team> teams;
	@JsonProperty("contact_methods")
	private List<ContactMethod> contactMethods;
	@JsonProperty("notification_rules")
	private List<NotificationRule> notificationRules;
	@JsonProperty("coordinated_incidents")
	private List<CoordinatedIncident> coordinatedIncidents;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public String getColor() {
		return color;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public boolean isBilled() {
		return billed;
	}

	public String getRole() {
		return role;
	}

	public String getDescription() {
		return description;
	}

	public boolean isInvitationSent() {
		return invitationSent;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public List<ContactMethod> getContactMethods() {
		return contactMethods;
	}

	public List<NotificationRule> getNotificationRules() {
		return notificationRules;
	}

	public List<CoordinatedIncident> getCoordinatedIncidents() {
		return coordinatedIncidents;
	}

}
