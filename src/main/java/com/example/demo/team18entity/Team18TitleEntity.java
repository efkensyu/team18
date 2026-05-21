package com.example.demo.team18entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "team18_titles")
@Data
public class Team18TitleEntity {
	@Id
	private long titleId;
	private String titleName;
	private String rarity;
}
