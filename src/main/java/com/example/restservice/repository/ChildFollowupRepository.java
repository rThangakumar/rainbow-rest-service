package com.example.restservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ChildFollowup;

@Repository
public interface ChildFollowupRepository extends JpaRepository<ChildFollowup,Integer>{

	List<ChildFollowup> findAllByChildNo(Long childNo);

}