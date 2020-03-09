package com.example.restservice.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.Country;

@Cacheable("Country")
public interface CountryRepository extends JpaRepository<Country, Integer> {

}