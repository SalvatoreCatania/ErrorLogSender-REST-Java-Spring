package com.error.sender.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.error.sender.model.ErrorMessage;

@Service
public class EmailService {

	private JavaMailSender mailSender;

	public EmailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(ErrorMessage errorMessage) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo("xxxxxxx@xxx.xxx");
		mailMessage.setSubject("Error with \"" + errorMessage.getSoftware() + "\":");
		mailMessage.setText("Generated at time:\n" + errorMessage.getTimestamp() + "\n\nError message:\n" + errorMessage.getMessage());
		mailMessage.setFrom("my-email@xxx.xxx");
		mailSender.send(mailMessage);
	}

}
