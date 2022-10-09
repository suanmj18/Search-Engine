package com.project.searchengine.Config;

import java.util.List;

public class User {

  private String firstName;
  private String lastName;
  private String emailId;
  private String username;
  private int numberOfSearchesPerformed;
  private List<String> permittedDrives;
  private UserPermission userPermission;

  public User(String firstName, String lastName, String username, String emailId, UserPermission userPermission) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailId = emailId;
    this.username = username;
    this.numberOfSearchesPerformed = 0;
    this.userPermission = userPermission;
    this.permittedDrives = List.of(new String[] { "C" });
  }

  public User(String firstName, String lastName, String emailId, String username) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailId = emailId;
    this.username = username;
    this.permittedDrives = null;
    this.userPermission = null;
  }

  public UserPermission getUserPermission() {
    return userPermission;
  }

  public void setUserPermission(UserPermission userPermission) {
    this.userPermission = userPermission;
  }

  public int getNumberOfSearchesPerformed() {
    return numberOfSearchesPerformed;
  }

  public void incrementNumberOfSearchesPerformed() {
    this.numberOfSearchesPerformed++;
  }

  public List<String> getPermittedDrives() {
    return permittedDrives;
  }

  public void permitAccessToDrive(String permittedDrive) {
    this.permittedDrives.add(permittedDrive);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void sendEmail(String content) {}

  @Override
  public String toString() {
    return
        "Name: " + getFirstName() + " " + getLastName()
        + "\nEmail ID: " + getEmailId()
        + "\nUsername: " + getUsername();

  }

  public void update() {}

}
