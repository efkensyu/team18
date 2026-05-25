package com.example.demo.team18entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "team18_book_tbl")
@Data

public class Team18BookEntity {
	@Id
	private Integer bookId;
	private String bookNm;
	private String author;
	private LocalDate publishDay;
	@Column(name = "zaiko")
	private Integer stock;
	private String cover;
}
