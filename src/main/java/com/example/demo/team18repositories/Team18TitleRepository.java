package com.example.demo.team18repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.team18entity.Team18TitleEntity;

@Repository
public interface Team18TitleRepository extends JpaRepository<Team18TitleEntity, Long> {
	
	@Query(value = "select * from team18_title_tbl", nativeQuery = true)
	public List<Team18TitleEntity> findAllTitles();

}
