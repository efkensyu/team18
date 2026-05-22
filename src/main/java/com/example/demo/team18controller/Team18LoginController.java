package com.example.demo.team18controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team18entity.Team18UserEntity;
import com.example.demo.team18service.team18LoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team18LoginController {
	private final team18LoginService tls;
//	ログイン画面表示
	@GetMapping("/team18librarylogin")
	public String loginpage(){
		return "team18login/team18login1";
	}
//	ログイン認証
	@PostMapping("/team18librarylogin")
	public String login(@RequestParam String userEmail ,@RequestParam String userPass,HttpSession session,Model model) {
		Team18UserEntity user = tls.login(userEmail, userPass);
		if(user == null) {
			
			model.addAttribute("errar","メールアドレスまたはパスワードがまちがっています。");
			return "team18login/team18login1";
		}
		session.setAttribute("loginUser", user);		
		return "team18login/team18login2";
	}
}
