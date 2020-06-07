package com.example.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ChildExitCredentials;
import com.example.restservice.crud.ChildHealth;

@Repository
public interface ChildExitCredentialsRepository extends JpaRepository<ChildExitCredentials, Long> {

	
}