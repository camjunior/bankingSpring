package com.kodigoApplaudo.group2.bankingSpring.Model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;


public class Transaction {

    private int accountId;

    private double amount;

    private TransactionType transactionType;
}
