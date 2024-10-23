package com.example.restservice.repository;

import com.example.restservice.crud.StateNetwork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StateNetworkRepository extends JpaRepository<StateNetwork, Short> {
    Optional<StateNetwork> findByStateNetworkNo(Short stateNetworkNos);
}
