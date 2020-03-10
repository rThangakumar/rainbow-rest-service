package com.example.restservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.HealthChecklistMultiple;

@Repository
public interface HealthChecklistMultipleRepository extends JpaRepository<HealthChecklistMultiple,Long> {

	Optional<HealthChecklistMultiple> findByChildNo(Integer childNo);

}