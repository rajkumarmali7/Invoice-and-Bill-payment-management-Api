package com.bord.bill.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bord.bill.demo.Entity.Bill;
import com.bord.bill.demo.Entity.Payment;
import com.bord.bill.demo.Service.BillService;
import com.bord.bill.demo.Service.PaymentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/Board")
public class BoardController {

	@Autowired
	BillService billService;
	
	@Autowired
	PaymentService paymentService;
	
	/** ========== Bill Save ============ **/
	@PostMapping("/Bill/save")
	public   ResponseEntity<Bill>  billSave(@RequestBody Bill bill)
	{
		Bill bill1 = billService.boardBill(bill);
	
		return new ResponseEntity<>(bill1, HttpStatus.OK);
	}
	
	/** ============ payment Save ==============**/
	@PostMapping("/payment/save")
	public ResponseEntity<Payment> paymentSave(@RequestBody Payment payment)
	{
		Payment  pay =paymentService.boardPayment(payment);
		return new ResponseEntity<>(pay ,HttpStatus.ACCEPTED);
	}
}
