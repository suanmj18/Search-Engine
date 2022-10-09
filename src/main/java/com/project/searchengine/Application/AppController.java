package com.project.searchengine.Application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @GetMapping("/")
  public String testMethod() {
    return "Welcome to Search Engine API!";
  }

}
