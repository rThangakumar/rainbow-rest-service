package com.example.restservice.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.Staff;

@Repository
@Cacheable("Staff")
public interface StaffRepository extends JpaRepository<Staff,Long> {
	
	List<Staff> findAll();

	List<Staff> findByOrgID(Integer orgId);

}