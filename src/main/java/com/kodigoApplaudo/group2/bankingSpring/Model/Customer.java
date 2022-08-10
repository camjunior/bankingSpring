package com.kodigoApplaudo.group2.bankingSpring.Model;

import lombok.Getter;
import lombok.Setter;

//import java.util.Collection;
//import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Customers")

public class Customer {


    @Id
    @Column(name="customer_id")
    @Getter @Setter  private int customer_id;

    @Column(name="customer_name")
    @Getter @Setter private String customer_name;

    @Column(name="phone")
    @Getter @Setter private String phone;


}
