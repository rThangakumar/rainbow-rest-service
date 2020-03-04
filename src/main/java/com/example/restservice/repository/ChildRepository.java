package com.example.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.Child;

@Repository
@Cacheable("Child")
public interface ChildRepository extends JpaRepository<Child, Long> {
		
	List<Child> findByRainbowHomeNumber(Integer rainbowHomeNumber);
	
	Optional<Child> findById(Long childNo);

}