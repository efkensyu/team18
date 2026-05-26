package com.example.demo.team18.team18service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.team18.team18entity.Team18UserEntity;
import com.example.demo.team18.team18repositories.Team18UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class team18LoginService {
	private final Team18UserRepository tur;
//ログイン
	public Team18UserEntity login(String userEmail, String userPass) {
		Optional<Team18UserEntity>  userop = tur.findByUserEmail(userEmail);
		
		if(userop.isEmpty()) {
		return null;
		}
	
	Team18UserEntity user = userop.get();
		
		if(!user.getUserPass().equals(userPass)) {
			return null;
		}
		return user;
	}


//新規登録
	public void register(String userEmail,String userPass,String userNm){
		Team18UserEntity regi = new Team18UserEntity();
		regi.setUserEmail(userEmail);
		regi.setUserNm(userNm);
		regi.setUserPass(userPass);
		
		tur.save(regi);
	}

}





