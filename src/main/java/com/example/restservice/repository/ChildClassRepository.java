package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.Child;

public interface ChildClassRepository extends JpaRepository<com.example.restservice.crud.ChildClass, Long> {

}