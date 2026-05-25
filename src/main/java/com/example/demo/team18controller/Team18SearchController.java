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
	private final Team18SearchService tss;
//	検索画面
	@GetMapping("/team18search")			
	public String index (Model model) {	
	    List<Team18BookEntity> bookList =tss.findAllByOrderByBookIdAsc();

        model.addAttribute("searchList", bookList);
		
		return "team18search/team18searchform";		
	}
//	検索結果表示画面	
	@PostMapping("/team18search")
	public String send (@RequestParam String keyword, Model model) {
		List<Team18BookEntity> searchlist;
		if(keyword.isEmpty()) {
			searchlist = tss.findAllByOrderByBookIdAsc();
		}
		else {
			searchlist = tss.findByBookNmContaining(keyword);
		}
		model.addAttribute("searchList",searchlist);
		return "team18search/team18searchresult";
	}
}