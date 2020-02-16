package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.crud.Community;

public interface CommunityRepository  extends JpaRepository<Community, Long>{

}