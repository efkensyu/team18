package com.example.demo.team18form;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Team18RegisterForm {
	
	@NotBlank(message = "メールアドレスを設定してください。")
	private String userEmail;
	
	@NotBlank(message = "パスワードを設定してください。")
	private String userPass;
	
	@NotBlank(message = "名前を設定してください。")
	private String userNm;

}
