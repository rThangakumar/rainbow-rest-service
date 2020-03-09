package com.example.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildAddress;
import com.example.restservice.crud.ChildEducation;

@Cacheable("ChildCommunication")
public interface ChildCommunicationRepository extends JpaRepository<ChildAddress, Integer> {

	Optional<ChildAddress> findByAddressNo(Integer childNo);

}