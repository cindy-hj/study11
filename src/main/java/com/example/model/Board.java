package com.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tbl_board")
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bno;
	
	@Column(length = 200)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column(length = 50)
	private String writer;
	
	private LocalDateTime regdate = LocalDateTime.now();
	
	private Integer viewcnt;
	
	private Integer replycnt;
	
	@JsonBackReference
	@OneToMany(mappedBy = "bno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Reply> replyItem = new ArrayList<>();
	
	@JsonBackReference
	@OneToMany(mappedBy = "bno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Attach> attachItem = new ArrayList<>();

	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}


}
