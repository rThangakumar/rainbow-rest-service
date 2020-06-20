package com.example.restservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ChildEnhanced;

@Repository
public interface ChildEnhancedRepository extends JpaRepository<ChildEnhanced,Long> {

	List<ChildEnhanced> findByRainbowHomeNumber(Integer homeNo);
	
	@Query(nativeQuery=true)
	List<ChildEnhanced> getChildListWithProflileStatusFlag(@Param("rainbowHomeNumber") Integer rainbowHomeNumber);

}