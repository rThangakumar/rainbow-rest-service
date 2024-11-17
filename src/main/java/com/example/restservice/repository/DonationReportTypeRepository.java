package com.example.restservice.repository;

import com.example.restservice.crud.DonationReportType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationReportTypeRepository extends JpaRepository<DonationReportType, Integer> {
}
