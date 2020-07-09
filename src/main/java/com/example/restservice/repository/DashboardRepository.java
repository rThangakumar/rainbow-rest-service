package com.example.restservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.restservice.crud.Dashboard;

public interface DashboardRepository extends JpaRepository<Dashboard,Long>{

	@Query(nativeQuery=true)
	List<Dashboard> getDashboardDetails(@Param("RBNo") Integer RBNo);
}
