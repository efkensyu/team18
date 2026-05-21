package com.example.demo.team18service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.demo.team18entity.Team18TitleEntity;
import com.example.demo.team18repositories.Team18TitleRepository;
import com.example.demo.team18repositories.Team18UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class team18GachaService {
	private final Team18TitleRepository titleRepo;
	private final Team18UserRepository userRepo;
	private final Random random = new Random();
	
	public Team18TitleEntity gacha() {
		List<Team18TitleEntity> none = new ArrayList<>();
		List<Team18TitleEntity> items = titleRepo.findAllTitles();//称号テーブルの内容を全て取り出す
		double totalWeight = 0;
		
		for(Team18TitleEntity item : items) {
			totalWeight += 100 / item.getRarity();//各要素のレアリティに応じた重みをすべて足す
		}
		
		double randomValue = random.nextDouble(totalWeight);//0から合計重みの間の数字をランダムに入れる
		double currentWeight = 0;
		
		for(Team18TitleEntity item : items) {
			currentWeight += 100 / item.getRarity();//各要素の重みを順にみながら足していき、randomValueの値を超えた瞬間の要素を出力する
			if (randomValue < currentWeight) {
				return item;
			}
			
			throw new IllegalStateException("ガチャの出力に失敗しました。");
			
		}
		return none.get(0);
	}
	
	
	
	

	

}
