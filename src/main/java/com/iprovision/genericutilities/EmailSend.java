package com.iprovision.genericutilities;

import java.io.IOException;    
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import org.testng.annotations.AfterTest;


public class EmailSend 
{
	@AfterTest
	public void sendingEmail(String to, String cc, String body,String subject)
	{
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new Authenticator() {
		
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication("cats4u@in2ittech.com","Support@202022");
			}
			}
		);

 
//		try {
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("cats4u@in2ittech.com"));
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//			message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
//			message.setSubject(subject);
//	
//			Path fileName = Path.of("");
//			
//	   
//			String str1 = Files.readString(fileName);
//			message.setContent(str1,"text/html");
//			System.out.println("Mail before sending:");
//	
//			Transport.send(message);
//			System.out.println("Mail Sent:");
//
//			} catch (MessagingException e) {
//				System.out.println("MessagingException: "+e);
//
//				} catch (IOException e) {
//					e.printStackTrace();
//					}
		
	}
}
