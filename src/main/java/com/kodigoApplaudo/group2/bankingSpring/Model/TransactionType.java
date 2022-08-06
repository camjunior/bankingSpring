package com.kodigoApplaudo.group2.bankingSpring.Model;

public enum TransactionType {
    DEPOSIT(0, "Deposit"),
    WITHDRAW(1, "Withdraw");

    public int code;
    public String description;

    private TransactionType(int code, String description) {
        this.code = code;
        this.description = description;
    }

}
