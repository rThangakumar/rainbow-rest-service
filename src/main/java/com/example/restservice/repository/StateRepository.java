package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.Country;
import com.example.restservice.crud.State;

public interface StateRepository extends JpaRepository<State, Integer> {

}