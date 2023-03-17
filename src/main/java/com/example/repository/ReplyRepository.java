package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

	List<Reply> findAllByBno(Integer bno);

}
