package com.example.demo.team18controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team18service.team18GachaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Team18GachaController {
	private final team18GachaService gachaService;
	
	@PostMapping(value = "/team18gacha", params = "donot")
	public String sendback() {
		return "team18menu/team18menu";
	}
	
	@PostMapping(value = "/team18gacha", params = "do")
	public String gachado() {
		gachaService.gacha(); //今は仮にgachaメソッドを置いているが、実際はgachaメソッド後の称号をユーザーに紐づけるメソッドを置きたい
		return "team18menu/team18menu";
	}
}
