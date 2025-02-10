package org.example;

public enum SavingAccountEnum {

    //we use this enumeration instead of multiple prints of options
    TYPE_1(" Type 1 - View Balance"),
    TYPE_2(" Type 2 - Withdraw Funds"),
    TYPE_3(" Type 3 - Deposit Funds"),
    TYPE_4(" Type 4 - Exit");

    private final String saveAccName;

    SavingAccountEnum(String saveAccName) {
        this.saveAccName = saveAccName;
    }

    public String getSaveAccName() {
        return saveAccName;
    }
}
