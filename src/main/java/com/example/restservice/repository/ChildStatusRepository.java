package com.example.restservice.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ChildStatus;

@Repository
@Cacheable("ChildStatus")
public interface ChildStatusRepository extends JpaRepository<ChildStatus,Long>{
	
	List<ChildStatus> findAll();

}