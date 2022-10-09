package com.project.searchengine.Transactions;

import com.project.searchengine.Config.User;

import java.sql.Timestamp;

public class Transaction {

  User user;
  String file;
  TransactionType action;
  Timestamp dateTime;

}
