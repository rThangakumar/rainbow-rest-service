package com.example.restservice.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.EducationStatus;

@Repository
@Cacheable("EducationStatus")
public interface EducationStatusRepository extends JpaRepository<EducationStatus, Long> {
	
	List<EducationStatus> findAll();
}