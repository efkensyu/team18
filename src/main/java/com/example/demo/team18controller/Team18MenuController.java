package com.example.demo.team18controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Team18MenuController {
	
	
	@PostMapping(value = "/team18return", params = "search")
	public String sendsearch() {//()のところはセッションで持ってきたユーザーのModelAttributeを入れる
		return "team18rental/team18kensakuin";
	}
	
	@PostMapping(value = "/team18return", params = "return")
	public String sendreturn() {//()のところはセッションで持ってきたユーザーのModelAttributeを入れる
		return "team18return/team18return";
	}


}
