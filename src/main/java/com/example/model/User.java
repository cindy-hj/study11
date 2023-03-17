package com.example.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_user")
public class User {
	@Id
	@Column(length = 50)
	private String uid;

	@Column(length = 50)
	private String upw;

	@Column(length = 100)
	private String uname;
	
	private Integer upoint;

	@Column(length = 50)
	private String sessionkey;
	
	private Timestamp sessionlimit;

	@JsonBackReference
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Message> messageItem = new ArrayList<>();
}
