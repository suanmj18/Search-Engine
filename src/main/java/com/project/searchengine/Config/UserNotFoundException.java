package com.project.searchengine.Config;

public class UserNotFoundException extends Exception {

  public UserNotFoundException() {
    super("The user was not found.");
  }

}
