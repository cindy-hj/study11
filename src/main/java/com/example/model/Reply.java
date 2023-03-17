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
@Table(name="tbl_reply")
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rno;
	
	//board bno FK
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="bno")
	@JsonManagedReference
	private Board bno;
	
	@Column(length = 1000)
	private String replytext;
	
	@Column(length = 50)
	private String replyer;
	
	private LocalDateTime regdate = LocalDateTime.now();
	
	private LocalDateTime updatedate;

	public Reply update(String replytext, String replyer) {
		this.replytext = replytext;
		this.replyer = replyer;
		this.updatedate = LocalDateTime.now();
		return this;
	}
}
