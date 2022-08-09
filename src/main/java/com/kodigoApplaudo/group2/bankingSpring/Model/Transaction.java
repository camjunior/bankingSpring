package com.kodigoApplaudo.group2.bankingSpring.Model;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Transaction {

    private Long id;

    private Account account;

    private BigDecimal amount;

    private TransactionType transactionType;
}
