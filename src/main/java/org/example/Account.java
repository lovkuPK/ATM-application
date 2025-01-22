package org.example;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0.0;
    private double savingBalance = 0.0;
    // here getters and setters for each variable
    // however, we do not create getters-setters for checkingBalance and
    // savingBalance variables
    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    //these four methods calculate checking and saving for both
    //withdrawal and deposit (a pair for each)
    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public double calcCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }
    //now the business-logic methods follow:
    //1)withdrawing the money from checking account
    //2)withdrawing the money from saving account
    //3)depositing the money to checking account
    //4)depositing the money to saving account

    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to withdraw from Checking Account: ");
        double amount = input.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));

        } else {
            System.out.println("Balance cannot be Negative." + "\n");
        }
    }

    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to withdraw from saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New saving Account Balance: " + moneyFormat.format(savingBalance));

        } else {
            System.out.println("Balance cannot be Negative." + "\n");
        }


    }
    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to deposit from Checking Account: ");
        double amount = input.nextDouble();

        if ((checkingBalance + amount) >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));

        } else {
            System.out.println("Balance cannot be Negative." + "\n");
        }

    }

    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to deposit from saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance + amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New saving Account Balance: " + moneyFormat.format(savingBalance));

        } else {
            System.out.println("Balance cannot be Negative." + "\n");
        }

    }

    public void sendMoneyToSavingAccount(){
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Enter the amount you want to transfer to Saving Account: ");
        double amount = input.nextDouble();

        if (checkingBalance - amount >= 0) {
            checkingBalance -= amount;
            savingBalance +=amount;

            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));

        } else {
            System.out.println("Balance cannot be Negative." + "\n");
        }
    }

    public void sendMoneyToCheckingAccount(){
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Enter the amount you want to transfer to Checking Account: ");
        double amount = input.nextDouble();

        if (savingBalance - amount >= 0) {
           savingBalance -= amount;
           checkingBalance +=amount;

            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));

        } else {
            System.out.println("Balance cannot be Negative." + "\n");
        }
    }

}

