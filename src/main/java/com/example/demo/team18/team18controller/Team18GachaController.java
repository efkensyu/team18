package com.example.demo.team18.team18controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team18.team18entity.Team18TitleEntity;
import com.example.demo.team18.team18entity.Team18UserEntity;
import com.example.demo.team18.team18service.team18GachaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Team18GachaController {
	private final team18GachaService tgs;
	
	@GetMapping("/team18gacha")
	public String gacha() {
		return "team18/team18gacha/Team18GachaPage";
	}
	@PostMapping("/team18gacha")
	public String gacharesult(Model model, HttpSession session) {
		String rarityname;
		Team18TitleEntity result = tgs.gacha();
		String name= result.getTitleNm();
		long titleid = result.getTitleId();
		int rarity= result.getRarity();
		if(rarity == 1) {
			rarityname = "R";
		}else if(rarity == 2) {
			rarityname = "SR";
		}else {
			rarityname = "SSR";
		}
		Team18UserEntity gachauser = (Team18UserEntity)session.getAttribute("loginUser");
		
		tgs.insert(titleid, gachauser.getUserEmail());
		gachauser.setTitleId(titleid);
		session.setAttribute("loginUser", gachauser);
		
		model.addAttribute("rarityname",rarityname);
		model.addAttribute("name",name);
		return "team18/team18gacha/team18gacharesult";
	}
}
