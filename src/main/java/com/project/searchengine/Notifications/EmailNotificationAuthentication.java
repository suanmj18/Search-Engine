package com.project.searchengine.Notifications;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class EmailNotificationAuthentication {
    static String username = "smtp.explorer1@gmail.com"; // set up sender
    static String password = "nedn hxyn lwtg diwe";  // set up an APP password

    public static Session SMTPAuthenticator() {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        return session;
    }
}
