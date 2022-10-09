package com.project.searchengine.Drives;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ActiveDriveFinder implements IDriveFinder {

  public List<String> getDrives(){

    List<String> drives = new ArrayList<>();

    for (File file : File.listRoots()) {
      if(file.canRead())
        drives.add(file.getAbsolutePath());
    }

    return drives;
  }

}
