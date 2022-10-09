package com.project.searchengine.Search;

public class SearchManagerFactory {

  public static ISearchManager create(){
    return new SearchManager();
  }

}
