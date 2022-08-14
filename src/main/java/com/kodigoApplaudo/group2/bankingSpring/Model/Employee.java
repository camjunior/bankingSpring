package com.kodigoApplaudo.group2.bankingSpring.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Employees")

public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="employee_id")
    @Getter @Setter private int employee_id;

    @Column(name="employee_name")
    @Getter @Setter private String employee_name;

    @Column(name="phone")
    @Getter @Setter private String phone;

    @Column(name="manager_id")
    @Getter @Setter private int manager_id;

    @Column(name="username")
    @Getter @Setter private String username;
}
