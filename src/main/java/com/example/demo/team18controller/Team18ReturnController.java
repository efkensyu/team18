package com.example.demo.team18controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team18service.Team18ReturnService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller	
public class Team18ReturnController {
	private final Team18ReturnService returnService;
	
	
	@PostMapping(value = "/team18return", params = "back")
	public String sendback() {
		return "team18manu/team18manu";
	}
	
	@PostMapping(value = "/team18return", params = "return")
	public String sendreturn() {
		
		
//		if(returnService.isReturn(session.getAttribute())) {//nullのところはセッションで持ってきたユーザーのModelAttributeの中のuserIdを入れる
//			return "team18return/team18gacha";
//		} else {
//			return "team18manu/team18return";
//		}
		return "team18menu/team18return";
	}
}

