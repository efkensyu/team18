package com.example.demo.team18controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team18entity.Team18BookEntity;
import com.example.demo.team18service.Team18SearchService;

import lombok.RequiredArgsConstructor;

@Controller		
@RequiredArgsConstructor
public class Team18SearchController {		
	private final Team18SearchService team18searchservice;
//	検索画面
	@GetMapping("/book")			
	public String index (Model model) {					
		return "team18book/team18bookin";		
	}
//	検索結果表示画面	
	@PostMapping("/book")
	public String send (@RequestParam String keyword, Model model) {
		List<Team18BookEntity> searchlist;
		if(keyword.isEmpty()) {
			searchlist = team18searchservice.findAllByOrderByBookIdAsc();
		}
		else {
			searchlist = team18searchservice.findByBookNmContaining(keyword);
		}
		model.addAttribute("searchList",searchlist);
		return "team18book/team18bookout";
	}
}