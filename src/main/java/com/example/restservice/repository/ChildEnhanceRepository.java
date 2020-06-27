package com.example.restservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.restservice.crud.ChildListEnhanced;

public interface ChildEnhanceRepository extends JpaRepository<ChildListEnhanced,Long>{
	
	@Query(nativeQuery=true)
	List<ChildListEnhanced> getChildEnhancedList(@Param("rainbowHomeNumber") Integer rainbowHomeNumber);

}
