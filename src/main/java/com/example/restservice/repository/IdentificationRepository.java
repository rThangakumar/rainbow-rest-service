package com.example.restservice.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.restservice.crud.Identification;

@Repository
@Cacheable("Identification")
public interface IdentificationRepository extends JpaRepository<Identification, Long>{
	
	List<Identification> findAll();

}