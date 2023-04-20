package com.bord.bill.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bord.bill.demo.Entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{

}
