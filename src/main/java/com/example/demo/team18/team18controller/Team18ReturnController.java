package com.example.demo.team18.team18controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team18.team18entity.Team18BookEntity;
import com.example.demo.team18.team18entity.Team18StatusEntity;
import com.example.demo.team18.team18entity.Team18UserEntity;
import com.example.demo.team18.team18repositories.Team18BookRepository;
import com.example.demo.team18.team18service.Team18ReturnService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller	
public class Team18ReturnController {
	private final Team18ReturnService trs;
	private final Team18BookRepository tbr;
	
	@PostMapping(value = "/team18return", params = "menu")
	public String sendback() {
		return "redirect:/team18menu";

	}
	
	@GetMapping(value = "/team18return", params = "returnbook")
	public String sendreturn(HttpSession session,Model model) {
	
		Team18UserEntity user =(Team18UserEntity)session.getAttribute("loginUser");
	
		Integer userId = user.getUserId();

		List<Team18StatusEntity> rentalList = trs.findRentalList(user.getUserId());
		
		 
		 List<Team18BookEntity> bookList = new ArrayList<>();
		 for (Team18StatusEntity status : rentalList) {
		        Team18BookEntity book =
		                tbr.findByBookIdEquals(status.getBookId());

		        bookList.add(book);
		    }
		   model.addAttribute("rentalList", rentalList);
		    model.addAttribute("bookList", bookList);
		 

		    return "team18/team18return/Team18returnconfirm";
	}

    @PostMapping(value = "/team18return", params = "return")
    public String sendreturn( @RequestParam(required = false) Integer logId,
            HttpSession session,
            Model model) {
        Team18UserEntity user =(Team18UserEntity) session.getAttribute("loginUser");

        List<Team18StatusEntity> rentalList = trs.findRentalList(user.getUserId());

        List<Team18BookEntity> bookList = new ArrayList<>();

        for (Team18StatusEntity status : rentalList) {
            Team18BookEntity book = tbr.findByBookIdEquals(status.getBookId());
            bookList.add(book);
        }
        
        if (logId == null) {

            model.addAttribute( "message","返却する本を選んでください");
            model.addAttribute("rentalList", rentalList);
            model.addAttribute("bookList", bookList);

            return "team18/team18return/Team18returnconfirm";
        }
        // 返却処理
        trs.returnBook(logId);

        return "redirect:/team18gacha";
    


}
}