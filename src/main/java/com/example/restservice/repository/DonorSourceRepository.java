package com.example.restservice.repository;

import com.example.restservice.crud.DonorSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorSourceRepository extends JpaRepository<DonorSource, Integer> {
}
