package com.example.restservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ChildLeavingReason;

@Repository
public interface ChildLeavingReasonRepository extends JpaRepository<ChildLeavingReason,Long> {

}