package com.bord.bill.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bord.bill.demo.Entity.Board;
import com.bord.bill.demo.Entity.Payment;
import com.bord.bill.demo.Repository.FetchBoardRepository;
import com.bord.bill.demo.Repository.PaymentRepository;

@Service
public class FindBoardService {
	
	@Autowired
	FetchBoardRepository fetchBoardRepository;
	

	public List<Board> getUaername(String username) {
	
		List<Board> board = fetchBoardRepository.findByUsername(username);
		return board;
	}

}
