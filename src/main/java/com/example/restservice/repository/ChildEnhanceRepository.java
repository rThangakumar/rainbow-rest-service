package com.example.restservice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.restservice.crud.ChildListEnhanced;

public interface ChildEnhanceRepository extends JpaRepository<ChildListEnhanced,Long>{
	
	@Query(nativeQuery=true)
	List<ChildListEnhanced> getChildEnhancedList(@Param("rainbowHomeNumber") Integer rainbowHomeNumber);
	
	@Transactional
	@Modifying
	@Query(nativeQuery=true)
	int updatePicture(@Param("picture") String picture,@Param("childNo") Integer childNo);

}