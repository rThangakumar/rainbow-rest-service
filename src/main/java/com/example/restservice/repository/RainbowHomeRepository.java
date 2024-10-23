package com.example.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildEducation;
import com.example.restservice.crud.RainbowHome;

public interface RainbowHomeRepository extends JpaRepository<RainbowHome, Integer> {
    Optional<RainbowHome> findByrhNo(Integer rhNo);

    List<RainbowHome> findByStateNetworkNoAndStatus(Short stateNetworkNo, Integer status);
    List<RainbowHome> findByStateNetworkNoInAndStatus(List<Short> stateNetworkNos, Integer status);
}