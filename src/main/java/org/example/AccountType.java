package org.example;

public enum AccountType {

    //we use this enumeration instead of multiple prints of options
    TYPE_1(" Type 1 - Checking Account"),
    TYPE_2(" Type 2 - Saving Account"),
    TYPE_3(" Type 3 - View Transaction History"),
    TYPE_4(" Type 4 - Transfer Funds Between Accounts"),
    TYPE_5(" Type 5 - Exit");

    private final String name;

    AccountType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
