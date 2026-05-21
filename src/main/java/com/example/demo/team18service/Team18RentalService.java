package com.example.demo.team18service;

import org.springframework.stereotype.Service;

import com.example.demo.team18entity.Team18UserEntity;
import com.example.demo.team18repositories.Team18BookRepository;
import com.example.demo.team18repositories.Team18StatusRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team18RentalService {
	private final Team18StatusRepository tsr;
	private final Team18BookRepository tbr;
	
	public void rentBook(String book,Team18UserEntity userId) {
//		Team18BookEntity bookId = Team18BookRepository findById
	}
}
