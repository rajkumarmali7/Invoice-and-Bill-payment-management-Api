package com.bord.bill.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@Table(name="paymentBoard")
public class Payment {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int paymentid;
	private int billNo;
	private String paymentboard;
	private String remarks;
	@Transient
	private double recivedamounts;
	private double totalrecivedamounts;
	private double pending;
	private String Date;

}