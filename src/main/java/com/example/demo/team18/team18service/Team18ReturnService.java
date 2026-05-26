package com.example.demo.team18.team18service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team18.team18entity.Team18BookEntity;
import com.example.demo.team18.team18entity.Team18StatusEntity;
import com.example.demo.team18.team18repositories.Team18BookRepository;
import com.example.demo.team18.team18repositories.Team18ReturnRepository;
import com.example.demo.team18.team18repositories.Team18StatusRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team18ReturnService {
	private final Team18ReturnRepository trr;
	private final Team18StatusRepository tsr;
	private final Team18BookRepository tbr;
	public List<Team18StatusEntity> findRentalList(Integer userId) {
	
		 return tsr.findByUserId(userId);
    }
    public void returnBook(Integer logId) {

        Team18StatusEntity status =
                tsr.findById(logId).orElseThrow();

        Integer bookId = status.getBookId();

        Team18BookEntity book =
                tbr.findById(bookId).orElseThrow();

        book.setStock(book.getStock() + 1);

        tbr.save(book);

        tsr.delete(status);
    }
}