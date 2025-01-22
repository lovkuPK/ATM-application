package org.example;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {

    //this class includes the logic of program's menu
    // here, we will include all the methods for the ATM work

    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    //this string formats numbers to currency format

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    // we use HM for login and password as numeric data

    public void getLogin() throws IOException {
        //this method allows to enter the ATM

        int x = 1;
        do {
            try {
                data.put(952141, 191904);
                data.put(989947, 71976);

                System.out.println("Welcome to the ATM Project!");
                System.out.println("Enter your customer Number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your PIN Number");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid Character(s). Numbers only." + "\n");
                x = 2;
            }
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else
                System.out.println("\n" + "Wrong Customer Number or Pin Number" + "\n");
        } while (x == 1);
    }

    public void getAccountType() {
        //this method accesses the account chosen
        System.out.println("Select the Account You Want to Access: ");
        System.out.println(" Type 1 - Checking Account");
        System.out.println(" Type 2 - Saving Account");
        System.out.println(" Type 3 - View Transaction History");
        System.out.println(" Type 4 - Transfer Funds Between Accounts");
        System.out.println(" Type 5 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                //viewTransactionHistory();
                System.out.println("This functionality is in work");
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
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Funds");
        System.out.println(" Type 3 - Deposit Funds");
        System.out.println(" Type 4 - Exit");

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
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Funds");
        System.out.println(" Type 3 - Deposit Funds");
        System.out.println(" Type 4 - Exit");
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

