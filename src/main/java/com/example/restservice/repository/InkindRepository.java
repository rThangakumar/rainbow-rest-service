package com.example.restservice.repository;

import com.example.restservice.crud.DonorType;
import com.example.restservice.crud.Inkind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InkindRepository extends JpaRepository<Inkind, Integer> {
}
