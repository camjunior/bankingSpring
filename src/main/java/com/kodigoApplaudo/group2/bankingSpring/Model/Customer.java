package com.kodigoApplaudo.group2.bankingSpring.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import java.util.Collection;
//import java.util.Set;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customers")
public class Customer {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id")
    @Getter @Setter  private int customer_id;

    @Column(name="customer_name")
    @Getter @Setter private String customer_name;

    @Column(name="phone")
    @Getter @Setter private String phone;

    @Column(name="username")
    @Getter @Setter private String username;


}
