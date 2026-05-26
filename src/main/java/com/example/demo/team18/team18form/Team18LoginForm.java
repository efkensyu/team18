package com.example.demo.team18.team18form;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Team18LoginForm {
	
	@NotBlank(message = "メールアドレスを入力してください。")
	private String userEmail;
	
	@NotBlank(message = "パスワードを入力してください。")
	private String userPass;

}
