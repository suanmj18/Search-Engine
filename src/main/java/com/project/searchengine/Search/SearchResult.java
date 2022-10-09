package com.project.searchengine.Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchResult {

  SearchResult() {
    this.searchResults = Collections.synchronizedList(new ArrayList<>());
  }

  private List<String> searchResults;

  public void addSearchResult(String path) {
    this.searchResults.add(path);
    this.searchResults = this.searchResults.stream()
        .distinct()
        .collect(Collectors.toList());
  }

  public void addSearchResults(List<String> paths) {
    this.searchResults.addAll(paths);
  }

  public List<String> getResults() {
    return searchResults;
  }

}
