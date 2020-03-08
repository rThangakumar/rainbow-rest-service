package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.Country;
import com.example.restservice.crud.Occupation;
import com.example.restservice.crud.Relation;

public interface OccupationRepository extends JpaRepository<Occupation, Integer> {

}