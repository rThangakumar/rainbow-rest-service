package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.Identification;

@Repository
public interface IdentificationRepository extends CrudRepository<Identification, Long>{

}