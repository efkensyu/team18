package com.example.demo.team18service;

import org.springframework.stereotype.Service;

import com.example.demo.team18repositories.Team18ReturnRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team18ReturnService {
	private final Team18ReturnRepository tretr;
	
	public boolean isReturn(String userEmail, HttpSession session) {
		Team18UserEntity user = (Team18UserEntity) session.getAttribute(userEmail);
		return returnRepository.existsBylogId(returnRepository.userIdGet(userEmail).get(0));
	}
	
	public List<Integer> userIdGet(Team) {
		return returnRepository.userIdGet(userEmail);
	}

}
