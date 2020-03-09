package com.example.restservice.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.Country;
import com.example.restservice.crud.District;
import com.example.restservice.crud.State;

@Cacheable("District")
public interface DistrictRepository extends JpaRepository<District, Integer> {

}