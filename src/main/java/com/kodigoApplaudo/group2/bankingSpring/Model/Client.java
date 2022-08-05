package com.kodigoApplaudo.group2.bankingSpring.Model;

import lombok.Getter;
import lombok.Setter;

//import java.util.Collection;
//import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTS")

public class Client {


    @Id
    @Column(name="CUSTOMERID")
    @Getter @Setter  private String customerId;

    @Column(name="NAME")
    @Getter @Setter private String name;


}
