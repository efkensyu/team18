package com.example.demo.team18.team18repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team18.team18entity.Team18TitleEntity;



@Repository
public interface Team18TitleRepository extends JpaRepository<Team18TitleEntity, Long> {

	public List<Team18TitleEntity> findByrarity(int rarity);
	
	@Query(value = "update team18_user_tbl set title_id = :titleid where user_email = :email", nativeQuery = true)
	public void insertTitle(@Param("titleid") long titleid, @Param("email") String email);

}
