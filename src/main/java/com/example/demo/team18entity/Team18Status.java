package com.example.demo.team18entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

public class Team18Status {
	@Entity
	@Table(name="status_tbl")
	@Data
	public class Team18User {
		@Id
		private Integer userId;
		private String bookId;
		private Integer rentStart;
		private Integer logId;
}
}