package com.bord.bill.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bord.bill.demo.Entity.Board;
import com.bord.bill.demo.Service.FindBoardService;

@RestController
public class FetchBoardByUsername {
	
	@Autowired
	FindBoardService findBoardService;

	/**-------- Get Data in Table through Particular Id -------------*/
	@GetMapping("/fetch/board/{username}")
	public ResponseEntity<List<Board>> bordfetchByusername(@PathVariable("username") String username)
	{
		List<Board> board = findBoardService.getUaername(username);
		 return new ResponseEntity<>(board ,HttpStatus.OK);
	}

}
