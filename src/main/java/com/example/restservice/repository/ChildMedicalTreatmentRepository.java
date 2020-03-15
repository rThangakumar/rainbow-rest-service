package com.example.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ChildHealth;
import com.example.restservice.crud.ChildMedicalTreatment;

@Repository
public interface ChildMedicalTreatmentRepository extends JpaRepository<ChildMedicalTreatment,Long> {

	List<ChildMedicalTreatment> findByChildNo(Long childNo);

	Optional<ChildMedicalTreatment> findByChildMedicalTreatmentNo(Integer childMedicalTreatmentNo);

}