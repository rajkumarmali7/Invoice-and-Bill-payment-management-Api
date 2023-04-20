package com.bord.bill.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bord.bill.demo.Entity.Board;

@EnableJpaRepositories
public interface FetchBoardRepository extends JpaRepository<Board,Integer>{

	List<Board> findByUsername(String username);

}
