package org.example;

public enum CheckingAccountEnum {
//we use this enumeration instead of multiple prints of options

    TYPE_1(" Type 1 - View Balance"),
    TYPE_2(" Type 2 - Withdraw Funds"),
    TYPE_3(" Type 3 - Deposit Funds"),
    TYPE_4(" Type 4 - Exit");

    private final String checkAccName;

    CheckingAccountEnum(String checkAccName) {
        this.checkAccName = checkAccName;
    }

    public String getCheckAccName() {
        return checkAccName;
    }
}
