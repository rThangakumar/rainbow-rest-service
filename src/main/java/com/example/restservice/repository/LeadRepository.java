package com.example.restservice.repository;

import com.example.restservice.crud.Lead;
import com.example.restservice.crud.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeadRepository extends JpaRepository<Lead, String> {

    List<Lead> findByOrganisationName(String name);
    List<Lead> findAllByLeadNo(String leadNo);
    List<Lead> findByOrgContactNumber(String mobileNo);
}
