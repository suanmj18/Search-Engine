package com.project.searchengine.Search;

import java.util.ArrayList;
import java.util.List;

public class SearchInfo {

  private String fileName;
  private List<String> drives;

  public SearchInfo(){
    this.drives = new ArrayList<>();
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public List<String> getDrives() {
    return drives;
  }

  public void setDrives(List<String> drives) {
    this.drives = drives;
  }

}
