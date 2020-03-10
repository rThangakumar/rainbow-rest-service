package com.example.restservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.HealthChecklistSingle;

@Repository
public interface HealthChecklistSingleRepository extends JpaRepository<HealthChecklistSingle,Long> {

	Optional<HealthChecklistSingle> findByChildNo(Integer childNo);

}