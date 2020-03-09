package com.example.restservice.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.Country;
import com.example.restservice.crud.Relation;

@Cacheable("Relation")
public interface RelationRepository extends JpaRepository<Relation, Integer> {

}