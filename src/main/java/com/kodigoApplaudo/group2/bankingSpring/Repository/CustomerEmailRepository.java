package com.kodigoApplaudo.group2.bankingSpring.Repository;

import com.kodigoApplaudo.group2.bankingSpring.Model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerEmailRepository extends JpaRepository<Manager, Long> {
}
