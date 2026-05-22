package com.example.demo.team18service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team18entity.Team18BookEntity;
import com.example.demo.team18repositories.Team18BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team18BookService {
	private final Team18BookRepository tbr;
	
	public List<Team18BookEntity> findAllByOrderByBookIdAsc(){
		return tbr.findAllByOrderByBookIdAsc();
	}
	
	public List<Team18BookEntity> findByBookNmContaining(String keyword){
		return tbr.findByBookNmContaining(keyword);
	}
	public Team18BookEntity findById(String bookId) {
		return tbr.findAllByBookId(bookId);
	}
}