package com.virtusa.mrviewer.system.event;

public class UserRegistrationEvent {
	private String username;
	private String email;

	public UserRegistrationEvent(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}
}
