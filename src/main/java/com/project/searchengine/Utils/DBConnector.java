package com.project.searchengine.Utils;

import java.sql.*;

public class DBConnector {

  public static  Connection connect()
  {
    Connection conn = null;
    try
    {
      //Load the Driver
      String driverClassName = "com.mysql.cj.jdbc.Driver"; //mysql6 - com.mysql.jdbc.Driver
      Class.forName(driverClassName);

      //Get the Connection
      String url ="jdbc:mysql://localhost:3306/searchengine";
      String user = "root";
      String password = "admin";

      conn = DriverManager.getConnection(url,user,password);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    return conn;

  }

}
