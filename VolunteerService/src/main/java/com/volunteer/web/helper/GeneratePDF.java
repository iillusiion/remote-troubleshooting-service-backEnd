package com.volunteer.web.helper;


import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class GeneratePDF {
	
	public static void sendWelcomeMail(String msg,String email,String subject) {
		 System.out.println("Starte - "+email);
	   final String username = "services.finomatic@gmail.com";
       final String password = "Finomatic@02";

       Properties prop = new Properties();
	   prop.put("mail.smtp.host", "smtp.gmail.com");
       prop.put("mail.smtp.port", "465");
       prop.put("mail.smtp.auth", "true");
       prop.put("mail.smtp.starttls.enable", "true");
       prop.put("mail.smtp.socketFactory.port", "465");
       prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
       
       Session session = Session.getInstance(prop,
               new javax.mail.Authenticator() {
                   protected PasswordAuthentication getPasswordAuthentication() {
                       return new PasswordAuthentication(username, password);
                   }
               });

       try {

       	Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(username, "Finomatic Admin"));
           message.addRecipient(
                   Message.RecipientType.TO,
                   new InternetAddress(email, "")
           );
           message.addRecipient(
                   Message.RecipientType.CC,
                   new InternetAddress("finomaticsolutions@gmail.com", "")
           );
           message.setSubject(subject);
           Multipart multipart = new MimeMultipart(); //1
        // Create the HTML Part
        BodyPart htmlBodyPart = new MimeBodyPart(); //4
        htmlBodyPart.setContent(msg, "text/html"); //5
       
        multipart.addBodyPart(htmlBodyPart); // 6
        // Set the Multipart's to be the email's content
        message.setContent(multipart); //7 

           Transport.send(message);

           System.out.println("Done");
       }catch(Exception e) {
    	   System.out.println("Exception in sending mail - "+e.getMessage());
       	e.printStackTrace();
       }
	}
	
	public static void sendMail(String msg,String email,String subject) {
		 System.out.println("Starte - "+email);
	   final String username = "services.finomatic@gmail.com";
      final String password = "Finomatic@02";

      Properties prop = new Properties();
	   prop.put("mail.smtp.host", "smtp.gmail.com");
      prop.put("mail.smtp.port", "465");
      prop.put("mail.smtp.auth", "true");
      prop.put("mail.smtp.starttls.enable", "true");
      prop.put("mail.smtp.socketFactory.port", "465");
      prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      
      Session session = Session.getInstance(prop,
              new javax.mail.Authenticator() {
                  protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication(username, password);
                  }
              });

      try {

      	Message message = new MimeMessage(session);
          message.setFrom(new InternetAddress(username, "KM Admin"));
          message.addRecipient(
                  Message.RecipientType.TO,
                  new InternetAddress(email, "")
          );
//          message.addRecipient(
//                  Message.RecipientType.CC,
//                  new InternetAddress("finomaticsolutions@gmail.com", "")
//          );
          message.setSubject(subject);
          Multipart multipart = new MimeMultipart(); //1
       // Create the HTML Part
       BodyPart htmlBodyPart = new MimeBodyPart(); //4
       htmlBodyPart.setContent(msg, "text/html"); //5
      
       multipart.addBodyPart(htmlBodyPart); // 6
       // Set the Multipart's to be the email's content
       message.setContent(multipart); //7 

          Transport.send(message);

          System.out.println("Done");
      }catch(Exception e) {
   	   System.out.println("Exception in sending mail - "+e.getMessage());
      	e.printStackTrace();
      }
	}

}


