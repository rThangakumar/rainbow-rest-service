package com.example.restservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.restservice.crud.ChildStayType;
import com.example.restservice.crud.HealthCampName;
import com.example.restservice.crud.SchoolName;

public interface HealthCampNameRepository extends JpaRepository<HealthCampName, Integer> {
	
	@Query(nativeQuery=true)
	List<HealthCampName> getUniqueCampName(@Param("rainbowHomeNumber") Integer rainbowHomeNumber);

}
