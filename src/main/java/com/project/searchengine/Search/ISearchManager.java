package com.project.searchengine.Search;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.searchengine.Drives.DriveFinderType;
import com.project.searchengine.Drives.InvalidDriveFinderChoiceException;
import org.springframework.web.bind.annotation.*;

public interface ISearchManager {

  SearchResult searchForFile(@RequestBody SearchInfo searchInfo);

  SearchResult searchForFileMT(@RequestBody SearchInfo searchInfo, @RequestBody
      DriveFinderType driveFinderType)
      throws InvalidDriveFinderChoiceException, JsonProcessingException;

}
