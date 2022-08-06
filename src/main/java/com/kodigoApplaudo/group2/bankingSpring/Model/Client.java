package com.kodigoApplaudo.group2.bankingSpring.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

//import java.util.Collection;
//import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTS")

public class Client {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMERID")
    private String customerId;

    @Getter
    @Setter
    @Column(name = "NAME")
    private String name;

    @Getter
    @Setter
    @Column(name = "DIU")
    private String diu;

    public Client(String customerId, String name, String diu) {
        this.customerId = customerId;
        this.name = name;
        this.diu = diu;
    }

    /*
     * public Client(Collection<String> name, Set<String> customerId) {
     * this.name = String.valueOf(name);
     * this.customerId = String.valueOf(customerId);
     * }
     */
}
