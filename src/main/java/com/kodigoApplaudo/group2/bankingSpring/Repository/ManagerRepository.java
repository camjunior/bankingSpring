package com.kodigoApplaudo.group2.bankingSpring.Repository;

import com.kodigoApplaudo.group2.bankingSpring.Model.Customer;
import com.kodigoApplaudo.group2.bankingSpring.Model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
