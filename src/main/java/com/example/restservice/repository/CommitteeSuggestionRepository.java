package com.example.restservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.CommitteeSuggestion;

@Repository
public interface CommitteeSuggestionRepository extends JpaRepository<CommitteeSuggestion,Long> {

	Optional<List<CommitteeSuggestion>> findAllByChildNo(Long childNo);

}