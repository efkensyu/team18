package com.example.demo.team18.team18repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team18.team18entity.Team18StatusEntity;



@Repository

public interface Team18ReturnRepository extends JpaRepository<Team18StatusEntity, Integer> {
	  List<Team18StatusEntity> findByUserId(Integer userId);
}
