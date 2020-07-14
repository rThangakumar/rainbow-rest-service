package com.example.restservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.*;

@Repository
public interface SchoolNameRepository extends JpaRepository<SchoolName,Long> {

	
	
	@Query(nativeQuery=true)
	List<SchoolName> getUniqueSchoolName(@Param("rainbowHomeNumber") Integer rainbowHomeNumber);

}