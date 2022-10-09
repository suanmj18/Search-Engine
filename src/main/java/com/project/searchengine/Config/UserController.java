package com.project.searchengine.Config;

import com.project.searchengine.Utils.DBConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

  private static final Logger LOGGER = LogManager.getLogger();

  @Autowired
  private UserService userService;

  @GetMapping("/test")
  @ResponseStatus(code = HttpStatus.OK)
  public void testMethod() {
    LOGGER.info("Test Method invoked to check void");
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED, reason = "User created successfully")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  public ResponseEntity<?> deleteUser(@RequestBody String username) {
    return userService.deleteUser(username);
  }

  @PostMapping("/login")
  @ResponseStatus(code = HttpStatus.OK)
  public ResponseEntity<?> login(@RequestBody String username) throws UserNotFoundException {
    return userService.login(username);
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return ResponseEntity.status(200).body(Collections.emptyList());
  }

}
