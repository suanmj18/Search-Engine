package com.project.searchengine.Drives;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AllDriveFinder implements IDriveFinder {

  public List<String> getDrives(){
    List<String> drives = new ArrayList<>();

    for(File f : File.listRoots()){
      drives.add(f.getAbsolutePath());
    }

    return drives;
  }

}
