package com.example.demo.team18service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team18entity.Team18StatusEntity;
import com.example.demo.team18repositories.Team18ReturnRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team18ReturnService {
	private final Team18ReturnRepository trr;

	
	public List<Team18StatusEntity> findRentalList(Integer userId) {
	
		 return trr.findByUserId(userId);
    }
	public void returnBook(Integer logId) {
        trr.deleteById(logId);
    }
}