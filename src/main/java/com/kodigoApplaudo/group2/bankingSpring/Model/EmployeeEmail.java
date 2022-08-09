package com.kodigoApplaudo.group2.bankingSpring.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeEmail")
public class EmployeeEmail {
    @Id
    @Column(name="idEmail")
    @Getter @Setter private int idEmail;

    @Column(name="employee_id")
    @Getter @Setter private int employee_id;

    @Column(name="email")
    @Getter @Setter private String email;
}
