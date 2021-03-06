package com.example.restservice.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ParentalStatus;

@Repository
@Cacheable("ParentalStatus")
public interface ParentalStatusRepository extends JpaRepository<ParentalStatus, Long> {
	
	List<ParentalStatus> findAll();

}