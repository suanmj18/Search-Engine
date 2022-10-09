package com.project.searchengine.Config;

public class InsufficientUserDataException extends Exception {

  public InsufficientUserDataException() {
    super("Insufficient User Data Provided");
  }

}
