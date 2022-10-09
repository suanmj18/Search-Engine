package com.project.searchengine.Transactions;

import com.project.searchengine.Utils.DBOperator;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

public class TransactionManager {

  public static void createTransactionsTable() {
    DBOperator.createTable(
        "create table transactionData "
            + "(user VARCHAR(255), "
            + "action VARCHAR(255), transactionTime Datetime);"
    );
  }

  public static void insert(String user, String Statement, TransactionType type){
    String sql = "insert into transactionData (`user`,`action`,`transactionTime`) values(?,?,?);";
    String[] listOfParameters={user,type.name(),String.valueOf(Timestamp.from(Instant.now()))};
    DBOperator.insert(2,sql,listOfParameters);
  }

}
