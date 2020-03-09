package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}