package com.example.restservice.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ReasonForAdmission;

@Repository
@Cacheable("ReasonForAdmission")
public interface ReasonForAdmissionRepository  extends JpaRepository<ReasonForAdmission, Long>{
	
	List<ReasonForAdmission> findAll();

}