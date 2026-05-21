package com.example.demo.team18entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user_tbl")
@Data
public class Team18UserEntity {
	@Id
	private Integer userId;
	private String userNm;
	private String userEmail;
	private String userPass;
}
