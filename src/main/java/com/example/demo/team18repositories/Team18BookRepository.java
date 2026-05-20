package com.example.demo.team18repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team18entity.Team18Book;

@Repository
public interface Team18BookRepository extends JpaRepository<Team18Book,String>{

}
