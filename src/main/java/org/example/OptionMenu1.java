package org.example;


import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class OptionMenu1 extends Account{
    Scanner menuInput = new Scanner(System.in);
    private static final HashMap<Integer, Integer> data = new HashMap<>(){{
        put(952141, 191904);
        put(989947, 71976);
    }};

    public void getLogin() {

        System.out.println("Welcome to the ATM project!");
        // Atomic flag to track user activity
        AtomicBoolean userStartedTyping = new AtomicBoolean(false);
        //Timer thread
        Thread timeoutThread = new Thread(() -> {
            try {
                for (int i = 0; i < 15; i++){
                    if (userStartedTyping.get()) return;
                    Thread.sleep(1000);
                }
                System.out.println("\nTime expired! Session terminated.");
                System.exit(0);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        timeoutThread.start();

        try{
            System.out.println("Enter your customer Number: ");
            if (menuInput.hasNext()) userStartedTyping.set(true);
            setCustomerNumber(menuInput.nextInt());

            System.out.println("Enter your PIN Number: ");
            if (menuInput.hasNext()) userStartedTyping.set(true);
            setPinNumber(menuInput.nextInt());


            int cn = getCustomerNumber();
            int pn = getPinNumber();
            //what does this part of code do??
            if (data.containsKey(cn) && data.get(cn) == pn){
                timeoutThread.interrupt();
                getAccountType();
            }else {
                System.out.println("\nWrong Customer Number or PIN Number.\n");
            }
        } catch (Exception e){
            System.out.println("\nInvalid input. Numbers only.\n");
        }
    }
    public void getAccountType() {
        //this method accesses the account chosen
        System.out.println("Select the Account You Want to Access: ");

        for (AccountType option:AccountType.values()){
            System.out.println(option.getName());

        }
        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                TransactionLogger.viewTransactionHistory();
                break;

            case 4:
                moneyTransferBetweenAccounts();
                break;

            case 5:
                System.out.println("Thank you for using this ATM \n");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
        }
    }

    public void getChecking() {
        //this is the account checking functionality
        System.out.println("Checking Account: ");

        for (CheckingAccountEnum choice:CheckingAccountEnum.values()) {
            System.out.println(choice.getCheckAccName());
        }

        System.out.println("Choice: ");
        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4: // Handle the "Exit" case
                System.out.println("Thank you for using this ATM.");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getChecking();
        }
    }

    public void getSaving() {
        //this is the account saving functionality
        System.out.println("Saving Account: ");

        for (SavingAccountEnum alternative:SavingAccountEnum.values()) {
            System.out.println(alternative.getSaveAccName());
        }

        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4: // Handle the "Exit" case
                System.out.println("Thank you for using this ATM.");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getChecking();
        }
    }

    public void moneyTransferBetweenAccounts() {
        //this is
        System.out.println("Choose the type of transaction: ");
        System.out.println(" Type 1 - From Checking Account to Saving Account");
        System.out.println(" Type 2 - From Saving Account to Checking Account");
        System.out.println(" Type 3 - Exit");
        System.out.println("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                sendMoneyToSavingAccount();
                getAccountType();
                break;

            case 2:
                sendMoneyToCheckingAccount();
                getAccountType();
                break;

            case 3:// Handle the "Exit to the previous menu" case
                System.out.println("Now you will be redirected to the previous menu.");
                getAccountType();
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getChecking();
        }
    }
}
