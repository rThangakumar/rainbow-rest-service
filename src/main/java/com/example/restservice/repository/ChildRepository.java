package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long>{

}