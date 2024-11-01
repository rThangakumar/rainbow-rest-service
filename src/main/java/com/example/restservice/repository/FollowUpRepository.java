package com.example.restservice.repository;

import com.example.restservice.crud.FollowUp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowUpRepository extends JpaRepository<FollowUp, Integer> {
    List<FollowUp> findByLeadNo(String leadNo);
}
