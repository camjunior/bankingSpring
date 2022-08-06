package com.kodigoApplaudo.group2.bankingSpring.Model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Transaction {

    private Account account;

    private double amount;

    private TransactionType transactionType;
}
