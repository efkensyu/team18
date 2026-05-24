package com.example.demo.team18service;

import org.springframework.stereotype.Service;

import com.example.demo.team18entity.Team18StatusEntity;
import com.example.demo.team18repositories.Team18ReturnRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team18ReturnService {
	private final Team18ReturnRepository trr;

	
	public Team18StatusEntity isReturn(Integer userId) {
	
		Team18StatusEntity tse = trr.findByuserId(userId);
		
		if(tse == null){
			return null;
		}
		
		trr.delete(tse);
		
		return tse;
	}
}	

