package com.example.demo.team18service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.demo.team18entity.Team18BookEntity;
import com.example.demo.team18entity.Team18StatusEntity;
import com.example.demo.team18repositories.Team18RentalRepository;
import com.example.demo.team18repositories.Team18StatusRepository.Team18StatusRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team18RentalService {
	private final Team18StatusRepository tsr;
	private final Team18RentalRepository trr;
	
	public void rentBook(String bookId,Integer userId) {
		Team18BookEntity book = trr.findByBookIdEquals(bookId);
				
				if(book.getStock() <= 0) {
					throw new RuntimeException("在庫なし");		
				}
		book.setStock(book.getStock() -1);
		
		Team18StatusEntity log = new Team18StatusEntity();
		
		log.setBookId(bookId);
		log.setUserId(userId);
		log.setRentStart(LocalDate.now());
		
		tsr.save(log);
		trr.save(book);
	}
}
