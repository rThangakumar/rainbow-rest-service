package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.restservice.crud.HealthCheckupList;

public interface HealthCheckUpRepository extends JpaRepository<HealthCheckupList, Integer> {

}
