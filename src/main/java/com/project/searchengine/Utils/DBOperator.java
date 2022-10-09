package com.project.searchengine.Utils;

import com.project.searchengine.Config.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperator {

  private static final Logger LOGGER = LogManager.getLogger();

  public static void createTable(String createStatement){
    try {
      Statement stat = DBConnector.connect().createStatement();
      //          String sql= "create table searchEngineData (user VARCHAR(255), filename VARCHAR(255), path VARCHAR(255))";
      stat.execute(createStatement);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static PreparedStatement statementToExecute(String sql, String[] listOfParameters){
    PreparedStatement ps = null;
    try {
      ps = DBConnector.connect().prepareStatement(sql);
      for(int i=1;i<=listOfParameters.length;i++){
        ps.setString(i,listOfParameters[i-1]);
      }
    } catch (Exception e) {
      LOGGER.error(e);
    }
    return ps;
  }

  public static void insert(int insertType,String sql,String[] listOfParameters){
    try {
      statementToExecute(sql,listOfParameters).executeUpdate();
    }catch (SQLException e){
//      switch (insertType){
//        case 1:
//      }
//      createTable();
      System.out.println(e);
    }
  }

  public static User getUserByUsername(String sql, String[] listOfParameters) {
    String username = null, firstname = null, lastname = null, emailId = null;
    try {
      ResultSet rs = statementToExecute(sql, listOfParameters).executeQuery();
//      System.out.println(rs.absolute(0));
      while (rs.next()) {
        username = rs.getString("username");
        lastname = rs.getString("lastname");
        firstname = rs.getString("firstname");
        emailId = rs.getString("emailid");
      }
      LOGGER.info(username);
    } catch (SQLException e){
      LOGGER.error(e);
    }

    User user = new User(firstname, lastname, emailId, username);
    return user;
  }

  public static List<String> searchInHistory(String sql,String[] listOfParameters){
    List<String> fileLocations= new ArrayList<>();
    try {
      ResultSet rs = statementToExecute(sql,listOfParameters).executeQuery();
      while(rs.next())
      {
        fileLocations.add(rs.getString("path"));
//        System.out.println("Filename: " + rs.getString("filename") + " FilePath: " + rs.getString("path"));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return fileLocations;
  }

  public static void deleteFileFromHistory(String sql,String[] listOfParameters){
      try {
        statementToExecute(sql,listOfParameters).executeUpdate();
        System.out.println("file is deleted");
      }catch (Exception e){
        System.out.println(e);
      }
    }
}
