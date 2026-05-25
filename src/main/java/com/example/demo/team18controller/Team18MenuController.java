package com.example.demo.team18controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Team18MenuController {
	
	@GetMapping("/team18menu")
	public String menu() {
		return "team18menu/team18menupage";
	}
	@PostMapping(value = "/team18menu", params = "search")
	public String sendsearch() {//()のところはセッションで持ってきたユーザーのModelAttributeを入れる
		return "team18search/team18searchform";
	}
	
	@PostMapping(value = "/team18menu", params = "return")
	public String sendreturn() {//()のところはセッションで持ってきたユーザーのModelAttributeを入れる
		return "team18return/team18returnconfilm";
	}


}
