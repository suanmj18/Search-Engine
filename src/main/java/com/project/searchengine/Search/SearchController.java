package com.project.searchengine.Search;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchController {

  private static final Logger LOGGER = LogManager.getLogger(SearchController.class);
  private static final ObjectMapper objectMapper = new ObjectMapper();

  @Autowired
  SearchManager searchManager;

  @Autowired
  SearchHistoryService searchHistoryService;

  @PostMapping("/single")
  public SearchResult searchForFiles(@RequestBody SearchInfo searchInfo) {
    return searchManager.searchForFile(searchInfo);
  }

//  @PostMapping("/multi")
//  public SearchResult searchForFilesMT(@RequestBody SearchInfo searchInfo)
//      throws InvalidDriveFinderChoiceException, JsonProcessingException {
//    LOGGER.info(objectMapper.writeValueAsString(searchInfo));
//    return searchManager.searchForFileMT(searchInfo, DriveFinderType.ALL);
//  }

  @DeleteMapping
  public ResponseEntity<Void> deleteFileFromHistory(@CookieValue("username") String username, @RequestBody String filename) {
    return searchHistoryService.deleteFileFromHistory(username, filename);
  }

}
