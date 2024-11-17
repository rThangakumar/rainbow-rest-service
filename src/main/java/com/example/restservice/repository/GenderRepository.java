package com.example.restservice.repository;

import com.example.restservice.crud.FollowUpMode;
import com.example.restservice.crud.Gender;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GenderRepository extends JpaRepository<Gender, Integer> {
}