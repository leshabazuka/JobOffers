package org.example.utils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class EmailSender {

    public static final String SENDER = System.getProperty("senderEmail");
    public static final String PASSWORD = System.getProperty("senderPassword");
    public static final String RECIPIENT = System.getProperty("recipientEmail");

    public static void sendMessage(List<String> urlAddresses) {
        String host = "127.0.0.1";
        Properties properties = System.getProperties();

        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.port", "vacanciesnotifier@gmail.com");

        Session session = Session.getDefaultInstance(properties);
        urlAddresses.forEach(url->sendOffer(session, url));
    }

    private static void sendOffer(Session session, String url){
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("vacanciesnotifier@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("leshatsiulya@gmail.com"));
            message.setSubject("JOB OFFERS");
            message.setText("Hi champion,\n\nThis is the link of offer you need.\n"+url);

            Transport tr = session.getTransport();
            tr.connect(null, PASSWORD);
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

