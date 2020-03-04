package com.example.restservice.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ReferralSource;

@Repository
@Cacheable("ReferralSource")
public interface ReferralSourceRepository extends JpaRepository<ReferralSource, Long> {
	
	List<ReferralSource> findAll();

}