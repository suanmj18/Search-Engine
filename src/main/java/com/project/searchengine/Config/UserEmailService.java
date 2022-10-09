package com.project.searchengine.Config;

import com.project.searchengine.Notifications.EmailNotificationService;
import org.springframework.stereotype.Service;

@Service
public class UserEmailService {

    //send the user detail which is logging in
    public void loginNotification(User user){
        String subject="Login Alert";
        String emailContent=" New login is done";
        EmailNotificationService.EmailNotification(subject,emailContent,user.getEmailId());
    }

    public void logoutNotification(User user){
        String subject="Logout Alert";
        String emailContent=" You are logged out from the search Engine System";
        EmailNotificationService.EmailNotification(subject,emailContent,user.getEmailId());
    }

    //mail to the user who is removed from the system
    public void userRemovedNotification(User user){
        String subject="Removed From the System!!";
        String emailContent=" You are removed from the search Engine System";
        EmailNotificationService.EmailNotification(subject,emailContent,user.getEmailId());
    }

    //mail to the user who removed the other user from the system
    public void userWhoRemovedNotification(User user){
        String subject="You Removed a user From the System!!";
        String emailContent=" You removed a user from the search Engine System";
        EmailNotificationService.EmailNotification(subject,emailContent,user.getEmailId());
    }

}
