package com.example.demo.team18repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.team18entity.Team18BookEntity;

public interface Team18RentalRepository extends JpaRepository<Team18BookEntity,String>{
	public Team18BookEntity findByBookIdEquals(String bookId);
	
}
