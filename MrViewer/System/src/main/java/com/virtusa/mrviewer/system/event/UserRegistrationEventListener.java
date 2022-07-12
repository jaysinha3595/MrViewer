package com.virtusa.mrviewer.system.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.virtusa.mrviewer.system.email.EmailBuilder;

@Component
public class UserRegistrationEventListener {
	
	@EventListener
	public void onEvent(UserRegistrationEvent event) {
		System.out.println("Event triggered");
		EmailBuilder builder =  new EmailBuilder(event.getEmail(), "Welcome to Mr.Viewer",
				"Hi ".concat(event.getUsername()).concat("! Your account is successfully created on Mr.Viewer\n"
						+ "Enjoy your favourite movies.\n\n"
						+ "Admin\nMr.Viewer")
				);
		builder.sendMessage();
	}

}
