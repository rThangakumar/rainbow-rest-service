package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.ChildStayType;
import com.example.restservice.crud.LiteracyStatus;

public interface LiteracyStatusRepository extends JpaRepository<LiteracyStatus, Integer> {

}
