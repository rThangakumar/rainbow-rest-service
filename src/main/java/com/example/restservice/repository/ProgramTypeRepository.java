package com.example.restservice.repository;

import com.example.restservice.crud.ProgramType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramTypeRepository extends JpaRepository<ProgramType, Integer> {
}
