package com.bord.bill.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Data
@Table(name="paymentBoardHistory")
public class PaymentHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int paymenthistoryid;
	private int billNo;
	private String paymentboard;
	private String remarks;
	private double recivedamounts;
	private double totalrecivedamounts;
	private double pending;
	private String Date;
	
	
	

}
