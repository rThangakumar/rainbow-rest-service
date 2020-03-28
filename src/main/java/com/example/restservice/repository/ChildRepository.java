package com.example.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildGeneralInfo;

@Transactional
@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
		
	List<Child> findByRainbowHomeNumber(Integer rainbowHomeNumber);
	
	Optional<Child> findById(Long childNo);
	
	@Modifying
	@Query("update Child child set child.identificationMark1 = ?1, child.identificationMark2 = ?2, child.stayReason = ?3, child.occupation = ?4, child.differentlyAbledGroup = ?5  WHERE child.childNo = ?6")	
	ResponseEntity<Child> save(String identificationMark1, String identificationMark2, Integer stayReason,
			Integer occupation, Integer differentlyAbledGroup, Integer childNo);
	
	@Modifying
	@Query("update Child child set child.childStatus = ?1  WHERE child.childNo = ?2")	
	Integer saveChildStatus(Integer childStatus, Long childNo);
	
	@Modifying
	@Query("update Child child set child.childStatus = ?1  WHERE child.childNo = ?2")	
	Integer saveChildBloodGroup(Integer bloodGroup, Long childNo);
}