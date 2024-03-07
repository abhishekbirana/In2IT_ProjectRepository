package com.practice;

import java.io.File;
import java.io.IOException;    
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMailWithAttachment {
 
 public static void main(String[] args) throws IOException {
  String to = "rktabhishek8@gmail.com"; // to address. It can be any like gmail, hotmail etc.
  final String from = "abhishek.birana@in2ittech.com"; // from address. As this is using Gmail SMTP.
  final String password = "!Admin@2023!"; // password for from mail address. 
 
  Properties prop = new Properties();
  prop.put("mail.smtp.host", "smtp.office365.com");
  prop.put("mail.smtp.port", "587");
  prop.put("mail.smtp.auth", "true");
  prop.put("mail.smtp.starttls.enable", "true");
  prop.put("mail.smtp.socketFactory.port", "587");
  prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 
  Session session = Session.getInstance(prop, new Authenticator() 
  {
	 @Override
   protected PasswordAuthentication getPasswordAuthentication() 
   {
    return new PasswordAuthentication(from, password);
   }
  });
 
  try {
 
   Message message = new MimeMessage(session);
   message.setFrom(new InternetAddress(from));
   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
   message.setSubject("Message from Java Simplifying Tech");
    
   String msg = "This email sent using JavaMailer API from Java Code!!!";
    
   MimeBodyPart mimeBodyPart = new MimeBodyPart();
   mimeBodyPart.setContent(msg, "text/html");
     
   MimeMultipart multipart = new MimeMultipart();
   multipart.addBodyPart(mimeBodyPart);
    
   MimeBodyPart attachmentBodyPart = new MimeBodyPart();
   attachmentBodyPart.attachFile(new File("D:\\eclipse-workspace\\IN2IT_TECHNOLOGIES\\ExtentReports\\Report-09-Oct-2023 10-40-22.html"));
   multipart.addBodyPart(attachmentBodyPart);
   message.setContent(multipart);
 
   Transport.send(message);
 
   System.out.println("Mail successfully sent..");
 
  } catch (MessagingException e) {
   e.printStackTrace();
  }
 }
}
