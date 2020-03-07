package com.example.restservice.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.Occupation;

@Repository
@Cacheable("Occupation")
public interface OccupationRepository extends JpaRepository<Occupation, Long>{
	
	List<Occupation> findAll();

}