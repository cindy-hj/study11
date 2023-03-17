package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Attach;

public interface AttachRepository extends JpaRepository<Attach, String> {

	List<Attach> findAllByBno(Integer bno);

	Attach findByFullnameAndBno(String fullname, Integer bno);

	void deleteByFullnameAndBno(String fullname, Integer bno);

}
