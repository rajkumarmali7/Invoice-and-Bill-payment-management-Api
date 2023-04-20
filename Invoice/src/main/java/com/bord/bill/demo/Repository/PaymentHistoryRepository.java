package com.bord.bill.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bord.bill.demo.Entity.PaymentHistory;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Integer> {

}
