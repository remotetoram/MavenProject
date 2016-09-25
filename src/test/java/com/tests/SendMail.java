package com.tests;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

//import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;

public class SendMail {

	public static String mailServer="smtp.gmail.com";
	
	
	
	public static void main(String [] args)
	   {    
		 
		    boolean debug = false;
			Properties props = new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.host", mailServer); 
			props.put("mail.debug", "true");
			
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
			props.setProperty("mail.smtp.socketFactory.fallback", "false");   
			props.setProperty("mail.smtp.port", "465");   
			props.setProperty("mail.smtp.socketFactory.port", "465");
		    
			Authenticator auth = new SMTPAuthenticator();
		    Session session = Session.getDefaultInstance(props, auth);
		    session.setDebug(debug);
		
		    
		    try
			{
				Transport bus = session.getTransport("smtp");
				bus.connect();
	            Message message = new MimeMessage(session);
	            //X-Priority values are generally numbers like 1 (for highest priority), 3 (normal) and 5 (lowest).
	            
	             message.addHeader("X-Priority", "1");
	             message.setFrom(new InternetAddress("remotetoram@gmail.com"));
	             
	             InternetAddress[] addressTo = new InternetAddress[1];
	             addressTo[0] = new InternetAddress("remotetoram@gmail.com");
	             message.setRecipients(Message.RecipientType.TO,addressTo);
	             message.setSubject("Happy Ram");
	                
	            BodyPart messagebody=new MimeBodyPart();
	            messagebody.setContent("Jiyo khul key","text/html");
	            //messagebody.addHeader("Jiyo khul key", "Jiyo khul key");
	            
	            	             
	             MimeMultipart MailParts= new MimeMultipart();
	             
	        
	             MailParts.addBodyPart(messagebody);
	             message.setContent(MailParts);
	             
	             
	             Transport.send(message);
	             System.out.println("Sucessfully Sent mail to All Users");
	         	 bus.close();
			}
			catch (MessagingException mex)
			{
	            mex.printStackTrace();
	        }
	   
	   
	   
	   }
}
class SMTPAuthenticator extends javax.mail.Authenticator
{

    public PasswordAuthentication getPasswordAuthentication()
    {
        String username = "remotetoram@gmail.com";
        String password = "12345";
        return new PasswordAuthentication(username, password);
    }
}