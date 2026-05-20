package com.example.demo.team18rental;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class Team18rKensaku {
	@GetMapping("/team18kensaku") 
	public String a() {
		return "team18kensakuin";
	}
	@PostMapping("/team18kensaku")
	public String send(@ModelAttribute KensakuForm kensakuForm) {
	return "team18kensakuout";
}
}