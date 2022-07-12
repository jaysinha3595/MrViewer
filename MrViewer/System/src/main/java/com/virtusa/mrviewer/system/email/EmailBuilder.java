package com.virtusa.mrviewer.system.email;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailBuilder {
	private String to;
	private String subject;
	private String text;
	
	private JavaMailSender mailSender = new JavaMailSenderImpl();
	
	
	public EmailBuilder(String to, String subject, String text) {
		super();
		this.to = to;
		this.subject = subject;
		this.text = text;
	}
	
	public void sendMessage() {
		try {
			System.out.println("Method Triggered!");
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			helper.setFrom("noreply@mrviewer.com");
			mailSender.send(message);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
