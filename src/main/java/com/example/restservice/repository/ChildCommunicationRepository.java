package com.example.restservice.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildAddress;
import com.example.restservice.crud.ChildEducation;

@Cacheable("ChildCommunication")
public interface ChildCommunicationRepository extends JpaRepository<ChildAddress, Integer> {

	Optional<ChildAddress> findByAddressNo(Integer childNo);
	
	@Procedure(procedureName = "ChildAddress.sp_Select_EmailIds")
	Map<Object,Object> getEmailIds(@Param("OrgId")Integer orgId);
	
	@Procedure("sp_Select_EmailIds")
	Map<Object,Object> getTotalCarsByModel(Integer id);

}