package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ChildStatus;

@Repository
public interface ChildStatusRepository extends JpaRepository<ChildStatus,Long>{

}