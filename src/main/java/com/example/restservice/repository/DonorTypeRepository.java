package com.example.restservice.repository;

import com.example.restservice.crud.DonorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorTypeRepository extends JpaRepository<DonorType, Integer> {
}
