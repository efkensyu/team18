package com.example.demo.team18entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "team18_book_tbl")
@Data

public class Team18BookEntity {
	@Id
	private String bookId;
	private String bookNm;
	private String author;
	private Integer publishDay;
	private Integer stock;
}
