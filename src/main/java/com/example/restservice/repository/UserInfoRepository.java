package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

	UserInfo findByuserName(String userName);

}