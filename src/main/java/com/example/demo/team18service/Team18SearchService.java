package com.example.demo.team18service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team18entity.Team18BookEntity;
import com.example.demo.team18repositories.Team18SearchRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team18SearchService {
	private final Team18SearchRepository tsr;
	
	public List<Team18BookEntity> findAllByOrderByBookIdAsc(){
		return tsr.findAllByOrderByBookIdAsc();
	}
	
	public List<Team18BookEntity> findByBookNmContaining(String keyword){
		return tsr.findByBookNmContaining(keyword);
	}
	public Team18BookEntity findById(Integer bookId) {
		return tsr.findAllByBookId(bookId);
	}
}