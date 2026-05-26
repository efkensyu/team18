package com.example.demo.team18controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team18entity.Team18StatusEntity;
import com.example.demo.team18entity.Team18UserEntity;
import com.example.demo.team18service.Team18ReturnService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller	
public class Team18ReturnController {
	private final Team18ReturnService trs;

	
	@GetMapping("/team18return")
	public String bookreturn() {

		return "team18return/team18returnpage";
	}
	@PostMapping(value = "/team18return", params = "menu")
	public String sendback() {
		return "redirect:/team18menu";

	}
	
	@PostMapping(value = "/team18return", params = "return")
	public String sendreturn(HttpSession session,Model model) {
	
		Team18UserEntity user =(Team18UserEntity)session.getAttribute("loginUser");
	
		

		List<Team18StatusEntity> rentalList = trs.findRentalList(user.getUserId());
		 model.addAttribute("rentalList", rentalList);

		    return "team18return/team18returnconfirm";
}	

    @PostMapping(value = "/team18return", params = "return")
    public String sendreturn(@RequestParam Integer logId) {

    trs.returnBook(logId);

    return "redirect:/team18gacha";

}
}