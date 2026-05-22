package com.example.demo.team18service;

import org.springframework.stereotype.Service;

import com.example.demo.team18entity.Team18UserEntity;
import com.example.demo.team18repositories.Team18ReturnRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team18ReturnService {
	private final Team18ReturnRepository returnRepository;
	
	public boolean isReturn(Team18UserEntity userEntity) {
		return returnRepository.existsBylogId(userEntity.getUserId());
	}

}
