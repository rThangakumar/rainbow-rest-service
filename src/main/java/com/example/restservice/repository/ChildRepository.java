package com.example.restservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.restservice.crud.Child;

public interface ChildRepository extends JpaRepository<Child, Long> {
		
	List<Child> findByRainbowHomeNumber(Integer rainbowHomeNumber);

}