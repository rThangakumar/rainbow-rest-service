package com.example.restservice.repository;

import com.example.restservice.crud.Sponsor;
import com.example.restservice.crud.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Integer> {

    List<Sponsor> findBySponsorNameStartingWith(String name);
    List<Sponsor> findBySponsorNoStartingWith(Integer sponsorNo);
    List<Sponsor> findByMobileNo(String mobileNo);
}

