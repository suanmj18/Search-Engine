package com.project.searchengine.Notifications;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.SearchTerm;

public class EmailNotificationService {

    public static void EmailNotification(String subject, String emailContent,String recieverEmail) {
        try {

            Message message = new MimeMessage(EmailNotificationAuthentication.SMTPAuthenticator());
            message.setFrom(new InternetAddress("smtp.explorer1@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recieverEmail));

            message.setSubject(subject);
            message.setText(emailContent);
            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}