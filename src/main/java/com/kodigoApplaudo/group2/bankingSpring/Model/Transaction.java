package com.kodigoApplaudo.group2.bankingSpring.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="Transactions")

public class Transaction {

    @Id
    @Column(name="transact_id")
    @Getter @Setter private int transact_id;

    @Column(name="account_id")
    @Getter @Setter private int account_id;

    @Column(name="transact_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Getter @Setter private Date transact_date;

    @Column(name="transact_time")
    @DateTimeFormat(pattern = "HH:mm")
    @Getter @Setter private Date transact_time;

    @Column(name="balance")
    @Getter @Setter private double balance;

    @Column(name="transact_type")
    @Getter @Setter  private TransactionType transact_type;
}
