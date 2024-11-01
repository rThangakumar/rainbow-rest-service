package com.example.restservice.repository;

import com.example.restservice.crud.LeadOrganisationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadOrganisationTypeRepository extends JpaRepository<LeadOrganisationType, Integer> {
}
