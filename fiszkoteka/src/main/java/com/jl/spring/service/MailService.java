package com.jl.spring.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class MailService {

	public void sendMail(String userEmail, String userPassword) {
		final String username = "test@yandex.com";
		final String password = "test";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.yandex.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("test@yandex.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(userEmail));
			message.setSubject("Przypomnienie has³a");
			message.setText("Drogi u¿ytkowniku," +
					"\n\n Twoje has³o to: "+userPassword);
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
