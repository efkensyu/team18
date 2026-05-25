package com.example.demo.team18controller;

import java.time.LocalDate;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team18entity.Team18BookEntity;
import com.example.demo.team18entity.Team18StatusEntity;
import com.example.demo.team18entity.Team18UserEntity;
import com.example.demo.team18repositories.Team18SearchRepository;
import com.example.demo.team18service.Team18ReturnService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller	
public class Team18ReturnController {
	private final Team18ReturnService trs;
	private final Team18SearchRepository tsr;
	
	@GetMapping("/team18return")
	public String bookreturn() {
		return "team18retrun/team18retrunconfirm";
	}
	@PostMapping(value = "/team18return", params = "menu")
	public String sendback() {
		return "team18manu/team18manupage";
	}
	
	@PostMapping(value = "/team18return", params = "return")
	public String sendreturn(HttpSession session,Model model) {
		Team18BookEntity book = null;
		LocalDate rentStart = null;
		String message;
		Team18UserEntity user =(Team18UserEntity)session.getAttribute("loginUser");
		Integer userId = user.getUserId();
		
		Team18StatusEntity judge = trs.isReturn(userId);

		
		if(judge == null) {
			message = "現在貸出中の本はございません";
		} else {
			message = "返却しますか?";
			book = tsr.findAllByBookId(judge.getBookId());
			
			rentStart = judge.getRentStart();
		}
		model.addAttribute("message",message);
		model.addAttribute("bookNm",book);
		model.addAttribute("rentStart",rentStart);
		return "team18menu/team18return";
	}
}

