package com.project.searchengine.Search;

import com.project.searchengine.Transactions.TransactionManager;
import com.project.searchengine.Transactions.TransactionType;
import com.project.searchengine.Utils.DBOperator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchHistoryService {

    public static void createTransactionsTable() {
        DBOperator.createTable(
                "create table searchEngineData (user VARCHAR(255),"
                        +" filename VARCHAR(255), path VARCHAR(255))"
        );
    }
    public void insert(String user,String fileName, String filePath) {
        String sql = "insert into searchEngineData (`user`,`filename`,`path`) values(?,?,?);";
        String[] listOfParameters={user,fileName,filePath};
        DBOperator.insert(1,sql,listOfParameters);
    }

    public List<String> searchInHistory(String user, String searchFileName) {
        String sql = "select filename,path from searchenginedata where filename=?;";
        String[] listOfParameters={searchFileName};
        TransactionManager.insert(user, searchFileName+" searched", TransactionType.SEARCH);
        return DBOperator.searchInHistory(sql,listOfParameters);
    }

    public ResponseEntity<Void> deleteFileFromHistory(String user, String filename) {
        String sql="delete from searchenginedata where filename=?;";
        String[] listOfParameters={filename};
        TransactionManager.insert(user, filename + " Deleted", TransactionType.DELETE);
        DBOperator.deleteFileFromHistory(sql,listOfParameters);

        return ResponseEntity.status(200).build();
    }

}
