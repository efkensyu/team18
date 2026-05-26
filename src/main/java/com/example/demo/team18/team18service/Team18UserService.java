package com.example.demo.team18.team18service;

import org.springframework.stereotype.Service;

import com.example.demo.team18.team18entity.Team18TitleEntity;
import com.example.demo.team18.team18repositories.Team18TitleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team18UserService {
	 private final Team18TitleRepository ttr;

	    // 称号IDから称号名取得
	    public String findTitleName(Long titleId) {

	        Team18TitleEntity title =
	                ttr.findById(titleId)
	                .orElse(null);

	        if(title == null) {
	            return null;
	        }

	        return title.getTitleNm();
	    }
}
