package com.example.demo.team18repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team18entity.Team18StatusEntity;

@Repository

public interface Team18ReturnRepository extends JpaRepository<Team18StatusEntity, Integer> {
	boolean existsBylogId(Integer userId);
}
