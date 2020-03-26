package com.example.restservice.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.MarkType;

@Repository
@Cacheable("MarkType")
public interface MarkTypeRepository extends JpaRepository<MarkType,Long>{
	
	List<MarkType> findAll();

}