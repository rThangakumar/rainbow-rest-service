package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ReferralSource;

@Repository
public interface ReferralSourceRepository extends JpaRepository<ReferralSource, Long> {

}
