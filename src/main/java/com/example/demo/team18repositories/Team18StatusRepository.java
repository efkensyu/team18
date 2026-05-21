package com.example.demo.team18repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.team18entity.Team18StatusEntity;

public interface Team18StatusRepository extends JpaRepository<Team18StatusEntity,Integer>{
	List<Team18StatusEntity> findByReturnedFalse();
	
}
