package com.bord.bill.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bord.bill.demo.Entity.Payment;

@EnableJpaRepositories
public interface PaymentRepository  extends JpaRepository<Payment, Integer>{

}
