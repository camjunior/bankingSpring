package com.kodigoApplaudo.group2.bankingSpring.Repository;

import com.kodigoApplaudo.group2.bankingSpring.Model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
