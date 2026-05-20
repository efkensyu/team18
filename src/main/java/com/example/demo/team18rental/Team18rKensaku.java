package com.example.demo.team18rental;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class Team18rKensaku {
	@GetMapping("/team18kensaku") 
	public String a() {
		return "team18rental/team18kensakuin";
	}
	@PostMapping("/team18kensaku")
	public String send(@ModelAttribute KensakuForm kensakuForm) {
	return "team18rental/team18kensakuout";
}
}