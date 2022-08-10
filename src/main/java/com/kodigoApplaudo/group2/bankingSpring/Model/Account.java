package com.kodigoApplaudo.group2.bankingSpring.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Accounts")
public class Account {

    @Id
    @Column(name="account_id")
    @Getter @Setter private int account_id;

    @Column(name="customer_id")
    @Getter @Setter private int customer_id;

    @Column(name="balance")
    @Getter @Setter double balance;

}