package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restservice.crud.ReasonForAdmission;

public interface ReasonForAdmissionRepository  extends JpaRepository<ReasonForAdmission, Long>{

}