package com.example.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.BloodGroup;
import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildAddress;
import com.example.restservice.crud.ChildEducation;
import com.example.restservice.crud.ChildFamily;

@Repository
public interface BloodGroupRepository extends JpaRepository<BloodGroup, Integer> {

	
}