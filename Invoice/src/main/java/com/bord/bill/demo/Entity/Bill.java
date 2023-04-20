package com.bord.bill.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name="Invoice")
public class Bill {
	
	@Id
	 private int billNo;
	 private String boardname;
	 private double amount;
	 private String remarks;
	 private String date;
	
	 

}
