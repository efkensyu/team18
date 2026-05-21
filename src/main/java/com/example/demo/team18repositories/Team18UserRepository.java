package com.example.demo.team18repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.team18entity.Team18UserEntity;

public interface Team18UserRepository extends JpaRepository<Team18UserEntity,Integer>{
	Optional<Team18UserEntity> findByEmail(String email);
}
