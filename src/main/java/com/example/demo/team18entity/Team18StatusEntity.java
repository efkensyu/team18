package com.example.demo.team18entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
@Entity
@Table(name="status_tbl")
@Data
public class Team18StatusEntity {
		private Integer userId;
		private String bookId;
		private Integer rentStart;
		@Id
		private Integer logId;
	
}
