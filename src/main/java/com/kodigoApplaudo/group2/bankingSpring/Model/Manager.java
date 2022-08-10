package com.kodigoApplaudo.group2.bankingSpring.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Managers")
public class Manager {

    @Id
    @Column(name="manager_id")
    @Getter @Setter private int manager_id;

    @Column(name="manager_name")
    @Getter @Setter private String manager_name;

    @Column(name="phone")
    @Getter @Setter private String phone;

}
