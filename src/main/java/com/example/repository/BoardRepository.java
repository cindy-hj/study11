package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
