package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ChildLeftPlace;

@Repository
public interface ChildLeftPlaceRepository extends JpaRepository<ChildLeftPlace,Long> {

}