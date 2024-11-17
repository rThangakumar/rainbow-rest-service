package com.example.restservice.repository;


import com.example.restservice.crud.SponsorshipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SponsorshipTypeRepository extends JpaRepository<SponsorshipType, Integer> {
//    List<SponsorshipType> findAllSponsorshipType();
}
