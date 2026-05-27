package com.example.demo.team18.team18controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team18.team18entity.Team18BookEntity;
import com.example.demo.team18.team18entity.Team18StatusEntity;
import com.example.demo.team18.team18entity.Team18UserEntity;
import com.example.demo.team18.team18repositories.Team18RentalRepository;
import com.example.demo.team18.team18service.Team18RentalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team18RentalController{
	private final Team18RentalService trs;
	private final Team18RentalRepository trr;
//	確認画面表示
	@PostMapping("/team18rental")
	public String rental (@RequestParam Integer bookId, Model model) {
	 
		Team18BookEntity book = trr.findByBookIdEquals(bookId);
		model.addAttribute("book",book);
		return "team18/team18rental/Team18RentalConfirm";
	}
//	確定画面
	@PostMapping("/team18rentalresult")
	public String go (@RequestParam Integer bookId,HttpSession session){
		
		Team18UserEntity user =(Team18UserEntity)
        session.getAttribute("loginUser");

		Team18StatusEntity log =new Team18StatusEntity();

		trs.rentBook(bookId, user.getUserId());
		
		return "team18/team18rental/team18rentalresult";
	}
}






