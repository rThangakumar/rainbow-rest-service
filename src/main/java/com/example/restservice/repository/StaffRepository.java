package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {

}