package com.project.searchengine.Search;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.searchengine.Drives.DriveFinderFactory;
import com.project.searchengine.Drives.DriveFinderType;
import com.project.searchengine.Drives.IDriveFinder;
import com.project.searchengine.Drives.InvalidDriveFinderChoiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class SearchManager implements ISearchManager {
  private static final Logger LOGGER = LogManager.getLogger(SearchManager.class);
  private static final ObjectMapper objectMapper = new ObjectMapper();

  private static SearchResult result = new SearchResult();

  public SearchResult getResult() {
    return result;
  }

  @Autowired
  SearchHistoryService searchHistoryService;

  @Override
  public SearchResult searchForFile(SearchInfo searchInfo) {
    result = new SearchResult();

    File[] files = new File("C://Users//rakhan//Downloads").listFiles();
//    SearchResult result = new SearchResult();
//    List<String> searchResult;
    searchFile(files, searchInfo.getFileName());
//    LOGGER.info(String.valueOf(searchResult));
//    result.addSearchResults(searchResult);
//    System.out.println(searchResult);
    return result;
  }

  private void searchFile(File[] files, String searchItem) {
    List<String> inHistoryResults = searchHistoryService.searchInHistory("temp", searchItem);
    if(inHistoryResults.size()>0) {
      result.addSearchResults(inHistoryResults);
      return;
    }


    for (File filename : files) {
      if (filename.isDirectory() && filename.listFiles() != null) {
        searchFile(Objects.requireNonNull(filename.listFiles()), searchItem);
      } else {
        if (filename.getName().contains(searchItem)) {
          searchHistoryService.insert("Ramiz", searchItem, filename.getAbsolutePath());
//          LOGGER.info(filename.toString());
          result.addSearchResult(filename.getAbsolutePath());
        }
      }
    }

    LOGGER.info(result.getResults());

  }

  @Override
  public SearchResult searchForFileMT(SearchInfo searchInfo, DriveFinderType driveFinderType)
      throws InvalidDriveFinderChoiceException, JsonProcessingException {
    result = new SearchResult();

    IDriveFinder driveFinder = DriveFinderFactory.create(driveFinderType);
    List<String> alld = new ArrayList<>();
    alld.add("C:\\Users\\rakhan\\Downloads");
    List<String> drives = alld;

    ExecutorService executorService = Executors.newFixedThreadPool(drives.size());
    List<String> temp = Collections.synchronizedList(new ArrayList<>());
    for (int i = 0; i < drives.size(); i++) {
      int finalI = i;
      executorService.execute(() -> searchFile(new File(drives.get(finalI)).listFiles(), searchInfo.getFileName()));
    }
    executorService.shutdown();
//    result.addSearchResults(temp);
    try {
      if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
        executorService.shutdownNow();
      }
    } catch (InterruptedException exception) {
      executorService.shutdownNow();
      Thread.currentThread().interrupt();
    }
    LOGGER.info(result.getResults());
    return SearchManager.result;
  }
}
