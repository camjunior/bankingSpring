package com.kodigoApplaudo.group2.bankingSpring.Model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ACCOUNT")
@Getter
@Setter

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    private Long id;

    private Client client;

    private BigDecimal balance;

    private Date dataCriacao;

    public Account() {

    }

    public Account(Long id, Client client, BigDecimal balance, Date dataCriacao) {
        this.id = id;
        this.client = client;
        this.balance = balance;
        this.dataCriacao = dataCriacao;
    }

}
