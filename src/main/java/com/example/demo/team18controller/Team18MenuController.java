package com.example.demo.team18controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team18entity.Team18UserEntity;
import com.example.demo.team18service.Team18UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Team18MenuController {
	private final Team18UserService tus;

	@GetMapping("/team18menu")
	public String menu(HttpSession session,Model model) {
		Team18UserEntity user =
				(Team18UserEntity)
				session.getAttribute("loginUser");

		model.addAttribute("user", user);

		if (user != null && user.getTitleId() != null) {
			String titleName = tus.findTitleName(user.getTitleId());
			model.addAttribute("titleName", titleName);
		}

		return "team18menu/team18menupage";
	}
	@PostMapping(value = "/team18menu", params = "search")
	public String sendsearch() {//()のところはセッションで持ってきたユーザーのModelAttributeを入れる
		return "team18search/team18searchform";
	}

	@PostMapping(value = "/team18menu", params = "return")
	public String sendreturn() {//()のところはセッションで持ってきたユーザーのModelAttributeを入れる
		return "team18return/team18returnpage";
	}


}
