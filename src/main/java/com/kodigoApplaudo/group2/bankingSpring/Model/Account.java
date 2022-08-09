package com.kodigoApplaudo.group2.bankingSpring.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ACCOUNT")
@Getter
@Setter

public class Account {

    private String customerId;

    private Client client;

    private double balance;

    public Account(String customerId, Client client, double balance) {
        this.customerId = customerId;
        this.client = client;
        this.balance = balance;
    }

}
