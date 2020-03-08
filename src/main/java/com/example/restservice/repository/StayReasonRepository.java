package com.example.restservice.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.StayReason;

@Repository
@Cacheable("StayReason")
public interface StayReasonRepository {
	List<StayReason> findAll();
}