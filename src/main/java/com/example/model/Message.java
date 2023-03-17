package com.example.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_message")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mid;

	// targetid FK
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="targetid") // db에 넣는 이름
	@JsonManagedReference
	private User user; // targetid로 하면 헷갈리니까!
	
	@Column(length = 50)
	private String sender;
	
	@Column(columnDefinition = "TEXT")
	private String message;
	
	private LocalDateTime opendate;
	
	private LocalDateTime senddate;
}
