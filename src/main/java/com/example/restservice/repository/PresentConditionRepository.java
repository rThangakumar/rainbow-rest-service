package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildClass;
import com.example.restservice.crud.PresentCondition;

public interface PresentConditionRepository extends JpaRepository<PresentCondition, Integer> {

}