package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.SchoolType;

public interface SchoolTypeRepository extends JpaRepository<SchoolType, Integer> {

}