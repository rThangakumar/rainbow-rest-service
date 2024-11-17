package com.example.restservice.repository;

import com.example.restservice.crud.ContributionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContributionDetailsRepository extends JpaRepository<ContributionDetails, Integer> {

}
