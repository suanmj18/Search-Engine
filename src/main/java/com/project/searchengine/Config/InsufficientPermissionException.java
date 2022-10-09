package com.project.searchengine.Config;

public class InsufficientPermissionException extends Exception {

  public InsufficientPermissionException() {
    super("User does not have sufficient permissions to execute operation");
  }

}
