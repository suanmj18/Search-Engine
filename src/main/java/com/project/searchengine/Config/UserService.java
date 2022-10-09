package com.project.searchengine.Config;

import com.project.searchengine.Transactions.TransactionManager;
import com.project.searchengine.Transactions.TransactionType;
import com.project.searchengine.Utils.DBConnector;
import com.project.searchengine.Utils.DBOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

@Service
public class UserService implements IUserService {

  @Autowired
  UserEmailService userEmailService;

  public ResponseEntity<User> createUser(User user) {
    String sql = "insert into users (`username`,`firstname`,`lastname`,`emailid`,`searchesPerformed`,`userPermission`,`permittedDrives`) values(?,?,?,?,?,?,?);";
    String[] listOfParameters = {
        user.getUsername(),
        user.getFirstName(),
        user.getLastName(),
        user.getEmailId(),
        String.valueOf(user.getNumberOfSearchesPerformed()),
        String.valueOf(user.getUserPermission()),
        String.valueOf(user.getPermittedDrives())
    };
    TransactionManager.insert(user.getUsername(), "user "+user.getUsername()+" added", TransactionType.CREATE_USER);
    DBOperator.insert(3,sql, listOfParameters);
    return ResponseEntity.status(201).body(user);
  }

  public ResponseEntity<?> login(String username) throws UserNotFoundException {
    ResponseCookie cookie = ResponseCookie.from("username", username).sameSite("None").path("/").build();

    User user = DBOperator.getUserByUsername("select * from users where username = ?", new String[]{username});
    if (user == null) {
      return ResponseEntity.status(404).body("User not found");
//      throw new UserNotFoundException();
    }

    TransactionManager.insert(username, "user "+ username +" logged in", TransactionType.LOGIN);


    userEmailService.loginNotification(user);

    return ResponseEntity.status(HttpStatus.OK)
        .header(HttpHeaders.SET_COOKIE, cookie.toString())
        .build();
  }

  @Override
  public ResponseEntity<Void> logout() {
    return null;
  }

//  TODO: Access control to be implemented
  public ResponseEntity<?> deleteUser(String username) {
    String sql="delete from users where username=?;";
    String[] listOfParameters = {username};
    TransactionManager.insert(username,username + " Deleted", TransactionType.USER_DELETED);
    DBOperator.deleteFileFromHistory(sql, listOfParameters);
    return ResponseEntity.status(200).build();
  }

  public List<User> getAllUsers() {
    String sql = "select * from users";
    Statement statement;
    try {
      statement = DBConnector.connect().createStatement();
      ResultSet rs = statement.executeQuery(sql);

      while (rs.next()) {

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return Collections.emptyList();
  }
}
