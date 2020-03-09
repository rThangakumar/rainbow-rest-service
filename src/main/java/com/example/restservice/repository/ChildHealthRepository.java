package com.example.restservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ChildHealth;

@Repository
public interface ChildHealthRepository extends JpaRepository<ChildHealth,Long> {
	
	Optional<ChildHealth> findByHealthNo(Integer healthNo); 

}