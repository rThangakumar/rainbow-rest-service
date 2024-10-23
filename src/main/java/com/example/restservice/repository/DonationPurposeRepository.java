package com.example.restservice.repository;

import com.example.restservice.crud.DonationPurpose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationPurposeRepository extends JpaRepository<DonationPurpose, Integer> {
}
