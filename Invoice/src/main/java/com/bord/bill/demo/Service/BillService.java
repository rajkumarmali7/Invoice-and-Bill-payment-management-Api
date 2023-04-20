package com.bord.bill.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bord.bill.demo.Entity.Bill;
import com.bord.bill.demo.Repository.BillRepository;

@Service
public class BillService {

	@Autowired
	BillRepository billRepository;
	
	public Bill boardBill(Bill bill) {
		
		 return billRepository.save(bill);
	}

	

}
