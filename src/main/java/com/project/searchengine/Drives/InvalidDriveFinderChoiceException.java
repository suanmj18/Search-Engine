package com.project.searchengine.Drives;

public class InvalidDriveFinderChoiceException extends Exception {

  public InvalidDriveFinderChoiceException(String msg) {
    super("Invalid Drive Finder Choice Exception has occurred :: " + msg);
  }

  public InvalidDriveFinderChoiceException() {
    super("Invalid Drive Finder Choice Exception has occurred");
  }

}
