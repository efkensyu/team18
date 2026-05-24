package com.example.demo.team18service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.demo.team18entity.Team18TitleEntity;
import com.example.demo.team18repositories.Team18TitleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class team18GachaService {
	private final Team18TitleRepository ttr;
	private final Random random = new Random();
	
	public Team18TitleEntity gacha() {
		int number = random.nextInt(100);
		
		int rarity;
//		R
		if(number < 40 ) {
			rarity = 1;
//		SR	
		}else if(number < 70) {
			rarity = 2;
//		SSR	
		}else {
			rarity = 3;
		}
		List<Team18TitleEntity> titles = ttr.findByrarity(rarity);
		
		int randomtitle = random.nextInt(titles.size());
		
		return titles.get(randomtitle);
	}
}







