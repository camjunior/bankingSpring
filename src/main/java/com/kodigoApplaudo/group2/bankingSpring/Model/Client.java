package com.kodigoApplaudo.group2.bankingSpring.Model;

import lombok.Getter;
import lombok.Setter;

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
    private String name;

    @Getter

    @Setter
    private String customerId;

    /*
     * public Client(Collection<String> name, Set<String> customerId) {
     * this.name = String.valueOf(name);
     * this.customerId = String.valueOf(customerId);
     * }
     */
}
