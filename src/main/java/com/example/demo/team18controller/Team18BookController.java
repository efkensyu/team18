package com.example.demo.team18controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team18entity.Team18BookEntity;
import com.example.demo.team18service.Team18BookService;

import lombok.RequiredArgsConstructor;

@Controller		
@RequiredArgsConstructor
public class Team18BookController {		
	private final Team18BookService team18bookservice;
	@GetMapping("/book")			
	public String index (Model model) {					
		return "team18bookin";		
	}
	
	@PostMapping("/book")
	public String send (@RequestParam String name, Model model) {
		List<Team18BookEntity> searchlist;
		if(name.isEmpty()) {
			searchlist = team18bookservice.findAllByOrderByBookIdAsc();
		}
		else {
			searchlist = team18bookservice.findByBookNmContaining(name);
		}
		return "team18bookout";
	}
}