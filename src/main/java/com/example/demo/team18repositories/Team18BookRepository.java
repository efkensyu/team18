package com.example.demo.team18repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team18entity.Team18BookEntity;

@Repository
public interface Team18BookRepository extends JpaRepository<Team18BookEntity,String>{

	public List<Team18BookEntity> findAllByOrderByBookIdAsc();
	public List<Team18BookEntity> findByBookNmContaining(String keyword);
}
