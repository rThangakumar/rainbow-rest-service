package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.Child;

public interface ChildRepository extends JpaRepository<Child, Long> {

}
