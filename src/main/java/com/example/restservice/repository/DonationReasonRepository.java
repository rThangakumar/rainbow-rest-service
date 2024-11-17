package com.example.restservice.repository;

import com.example.restservice.crud.DonationReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationReasonRepository extends JpaRepository<DonationReason, Integer> {
}
