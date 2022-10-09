//package com.project.searchengine;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.project.searchengine.Drives.DriveFinderType;
//import com.project.searchengine.Drives.InvalidDriveFinderChoiceException;
//import com.project.searchengine.Notifications.EmailNotificationService;
//import com.project.searchengine.Search.SearchInfo;
//import com.project.searchengine.Search.SearchManager;
//import com.project.searchengine.Search.SearchResult;
//import com.project.searchengine.Transactions.TransactionManager;
//import com.project.searchengine.Transactions.TransactionType;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestMain {
//    public static void main(String[] args) throws InvalidDriveFinderChoiceException, JsonProcessingException {
//
//        EmailNotificationService.EmailNotification("testing","this is atesting mail");
////        SearchManager s=new SearchManager();
//////        TransactionManager.insert("helol","hello", TransactionType.CREATE);
////        TransactionManager.createTransactionsTable();
//        String path = "C:\\Users\\rakhan\\Downloads";
//        SearchInfo si= new SearchInfo();
//        List<String> alld= new ArrayList<String>();
//        alld.add("C:\\Users\\rakhan\\Downloads");
//        si.setDrives(alld);
//        si.setFileName(".zip");
//        SearchResult sr = s.searchForFileMT(si, DriveFinderType.ALL);
////        String path = "C:\\Users\\sukumar\\Downloads";
////        SearchInfo si= new SearchInfo();
////        List<String> alld= new ArrayList<String>();
////        alld.add("C:\\Users\\sukumar\\Downloads");
////        si.setDrives(alld);
////        si.setFileName(".zip");
////        s.searchForFileMT(si, DriveFinderType.ALL);
////
////        try {
////            s.searchForFileMT(si, DriveFinderType.ACTIVE);
////        }catch (Exception e){
////            System.out.println(e);
////        }
//
//    }
//}
