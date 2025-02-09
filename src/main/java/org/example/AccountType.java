package org.example;

import java.util.stream.Stream;

public enum AccountType {

    TYPE_1(" Type 1 - Checking Account"),
    TYPE_2(" Type 2 - Saving Account"),
    TYPE_3(" Type 3 - View Transaction History"),
    TYPE_4(" Type 4 - Transfer Funds Between Accounts"),
    TYPE_5(" Type 5 - Exit");

    private String name;

    AccountType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
//    public static Stream<AccountType> stream(){
//        return Stream.of(AccountType.values());
//        }
}
