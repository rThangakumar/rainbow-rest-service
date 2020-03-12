package com.example.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.ProfileDescription;

@Repository
public interface ProfileDescriptionRepository extends JpaRepository<ProfileDescription,Long> {

	Optional<List<ProfileDescription>> findAllByChildNo(Long childNo);

}