package com.example.restservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.restservice.crud.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
}