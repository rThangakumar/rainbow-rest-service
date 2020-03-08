package com.example.restservice.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.DifferentlyAbledGroup;

@Repository
@Cacheable("DifferentlyAbledGroup")
public interface DifferentlyAbledGroupRepository  extends JpaRepository<DifferentlyAbledGroup,Long>{
	
	List<DifferentlyAbledGroup> findAll();

}
