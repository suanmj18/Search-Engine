package com.project.searchengine.Config;

import org.springframework.http.ResponseEntity;

public interface IUserService {

  ResponseEntity<User> createUser(User user);

  ResponseEntity<?> login(String username) throws UserNotFoundException;

  ResponseEntity<Void> logout();

}
