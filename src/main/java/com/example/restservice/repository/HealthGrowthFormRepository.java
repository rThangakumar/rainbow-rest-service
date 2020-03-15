package com.example.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ChildMedicalTreatment;
import com.example.restservice.crud.HealthGrowthForm;

@Repository
public interface HealthGrowthFormRepository extends JpaRepository<HealthGrowthForm,Long> {

	List<HealthGrowthForm> findByChildNo(Long childNo);

	Optional<HealthGrowthForm> findByHealthGrowthFormNo(Integer healthGrowthFormNo);

}