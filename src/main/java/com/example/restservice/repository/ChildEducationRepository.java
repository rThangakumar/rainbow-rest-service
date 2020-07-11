package com.example.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildEducation;

public interface ChildEducationRepository extends JpaRepository<ChildEducation, Integer> {

	Optional<List<ChildEducation>> findByChildNo(Integer childNo);

}