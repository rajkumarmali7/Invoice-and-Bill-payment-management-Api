package com.bord.bill.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Boards")
@Data
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int boardID;
   private String board;
   private String username;
  
}
