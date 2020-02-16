package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.Religion;

@Repository
public interface ReligionRepository extends JpaRepository<Religion, Long>{

}