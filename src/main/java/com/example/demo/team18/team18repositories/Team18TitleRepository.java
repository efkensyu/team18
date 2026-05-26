package com.example.demo.team18.team18repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team18.team18entity.Team18TitleEntity;



@Repository
public interface Team18TitleRepository extends JpaRepository<Team18TitleEntity, Long> {

	public List<Team18TitleEntity> findByrarity(int rarity);

}
