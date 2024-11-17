package com.example.restservice.repository;

import com.example.restservice.crud.Lead;
import com.example.restservice.crud.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeadRepository extends JpaRepository<Lead, String> {

    List<Lead> findByOrganisationNameAndConvertedToDonor(String name, Boolean convertedToDonor);
    List<Lead> findAllByLeadNoAndConvertedToDonor(String leadNo, Boolean convertedToDonor);
    List<Lead> findByOrgContactNumberAndConvertedToDonor(String mobileNo, Boolean convertedToDonor);
    Lead findByLeadNo(String leadNo);
}
