package org.example;

import org.tinylog.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransactionLogger {

    private static final List<String> sessionLogs = new ArrayList<>();
    //this formatter
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //this method writes transactions to logs
    public static void logTransaction (String message){

        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = String.format("[%s] %s", timestamp, message);

        //Logger.info("[{}] {}", timestamp, message);
        sessionLogs.add(logEntry);
    }
    //this method views all the transaction history
    public static void viewTransactionHistory(){
        if(sessionLogs.isEmpty()){
            System.out.println("No transactions recorded during this session.");
        } else {
            System.out.println("Transaction history: ");
            sessionLogs.forEach(System.out::println);//what does this string do??
        }
    }

}
