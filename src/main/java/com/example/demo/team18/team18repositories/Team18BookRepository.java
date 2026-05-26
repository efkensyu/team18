package com.example.demo.team18.team18repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.team18.team18entity.Team18BookEntity;

public interface Team18BookRepository extends JpaRepository<Team18BookEntity, Integer>{
	
	  Team18BookEntity findByBookIdEquals(Integer bookId);
}

