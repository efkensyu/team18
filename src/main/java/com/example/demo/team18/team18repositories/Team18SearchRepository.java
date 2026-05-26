package com.example.demo.team18.team18repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team18.team18entity.Team18BookEntity;



@Repository
public interface Team18SearchRepository extends JpaRepository<Team18BookEntity,Integer>{


	public List<Team18BookEntity> findAllByOrderByBookIdAsc();
	public List<Team18BookEntity> findByBookNmContaining(String keyword);
	public Team18BookEntity findAllByBookId(Integer bookId);
	
}
