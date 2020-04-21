package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.ScholarshipType;

public interface ScholarshipTypeRepository extends JpaRepository<ScholarshipType, Integer> {

}
