package com.example.restservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.restservice.crud.ChildStayType;
import com.example.restservice.crud.HealthHospitalName;
import com.example.restservice.crud.SchoolName;

public interface HealthHospitalNameRepository extends JpaRepository<HealthHospitalName, Integer> {
	
	@Query(nativeQuery=true)
	List<HealthHospitalName> getUniqueHospitalName(@Param("rainbowHomeNumber") Integer rainbowHomeNumber);

}
