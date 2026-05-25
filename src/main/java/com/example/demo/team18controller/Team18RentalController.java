package com.example.demo.team18controller;

import java.time.LocalDate;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team18entity.Team18BookEntity;
import com.example.demo.team18entity.Team18StatusEntity;
import com.example.demo.team18entity.Team18UserEntity;
import com.example.demo.team18repositories.Team18RentalRepository;
import com.example.demo.team18repositories.Team18StatusRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team18RentalController{
	private final Team18StatusRepository tsr;
	private final Team18RentalRepository trr;
//	確認画面表示
	@GetMapping("/team18rental")
	public String rental (@RequestParam Integer bookId, Model model) {
		Team18BookEntity book = trr.findByBookIdEquals(bookId);
		model.addAttribute("book",book);
		return "team18rental/team18rentalconfirm";
	}
//	確定画面
	@PostMapping("/team18rental")
	public String go (@RequestParam Integer bookId,HttpSession session){
		
		Team18UserEntity user =(Team18UserEntity)
        session.getAttribute("loginUser");

		Team18StatusEntity log =new Team18StatusEntity();

		log.setBookId(bookId);
		log.setUserId(user.getUserId());
		log.setRentStart(LocalDate.now());
		tsr.save(log);		
		return "/team18menu";
	}
}






