package com.example.demo.team18service;

import org.springframework.stereotype.Service;

import com.example.demo.team18repositories.Team18BookRepository;
import com.example.demo.team18repositories.Team18StatusRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team18RentalService {
	private final Team18StatusRepository tsr;
	private final Team18BookRepository tbr;
	
/*	public void rentBook(String bookId,Integer userId) {
		Team18BookEntity book = Team18BookRepository.findByBookNameContaining()
				
				if(book.getStock() <= 0) {
					throw new RuntimeException("在庫なし");		
				}
		book.setStock(book.getStock() -1);
		
		Team18StatusEntity log = new Team18StatusEntity();
		
		log.setBookId(bookId);
		log.setUserId(userId);
		log.setRentStart(LocalDate.now());
		
		Team18StatusRepository.save(log);
		Team18BookRepository.save(book);
	}*/
}
