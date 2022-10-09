package com.project.searchengine.Drives;

public class DriveFinderFactory {

  public static IDriveFinder create(DriveFinderType choice) throws InvalidDriveFinderChoiceException {
    IDriveFinder finder = null;

    if(choice.equals(DriveFinderType.ALL))
      finder = new AllDriveFinder();
    else if(choice.equals(DriveFinderType.ACTIVE))
      finder = new ActiveDriveFinder();
    else
      throw new InvalidDriveFinderChoiceException("Invalid Choice");

    return finder;
  }

}
