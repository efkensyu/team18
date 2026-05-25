package com.example.demo.team18controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team18entity.Team18UserEntity;
import com.example.demo.team18form.Team18LoginForm;
import com.example.demo.team18form.Team18RegisterForm;
import com.example.demo.team18service.team18LoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team18LoginController {
	private final team18LoginService tls;

	//	ログイン画面表示
	@GetMapping("/team18librarylogin")
	public String loginpage() {
		return "team18login/team18login1";
	}

	//	ログイン認証
	@PostMapping("/team18librarylogin")
	public String login(@ModelAttribute Team18LoginForm team18LoginForm, HttpSession session, Model model,
			BindingResult result) {
		Team18UserEntity user = tls.login(team18LoginForm.getUserEmail(), team18LoginForm.getUserPass());
		if (result.hasErrors()) {
			return "team18login/team18login1";
		}
		if (user == null) {

			model.addAttribute("errar", "メールアドレスまたはパスワードがまちがっています。");
			return "team18login/team18login1";
		}
		session.setAttribute("loginUser", user);
		return "team18login/team18menu";
	}

	@GetMapping("/team18register")
	public String registerPage() {

		return "team18login/Team18Register";
	}

	@PostMapping("/team18register")
	public String registermenu(@ModelAttribute Team18RegisterForm team18RegisterForm, Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			return "team18login/Team18Register";
		}

		tls.register(team18RegisterForm.getUserEmail(), team18RegisterForm.getUserPass(),
				team18RegisterForm.getUserNm());

		model.addAttribute("msg", "登録完了しました");

		return "team18login/team18login1";
	}

}
