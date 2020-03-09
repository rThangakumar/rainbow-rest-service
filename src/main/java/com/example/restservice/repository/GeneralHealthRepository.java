package com.example.restservice.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.GeneralHealth;

@Repository
@Cacheable("GeneralHealth")
public interface GeneralHealthRepository extends JpaRepository<GeneralHealth,Long>{

}