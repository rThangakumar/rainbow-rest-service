package com.example.restservice.repository;

import com.example.restservice.crud.LeadDonation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadDonationRepository extends JpaRepository<LeadDonation, Integer> {
}
