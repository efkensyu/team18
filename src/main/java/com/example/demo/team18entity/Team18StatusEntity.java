package com.example.demo.team18entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
@Entity
@Table(name="team18_status_tbl")
@Data
public class Team18StatusEntity {
		private Integer userId;
		private Integer bookId;
		private LocalDate rentStart;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer logId;
		
	
}
