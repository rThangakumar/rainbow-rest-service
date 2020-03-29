package com.example.restservice.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.crud.UserInfo;
import com.example.restservice.dto.UserLoginResponseDTO;
import com.example.restservice.repository.UserInfoRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@GetMapping("/user-login/{userName}")
	@Cacheable("UserLogin")
	public UserLoginResponseDTO getUserLogin(@PathVariable String userName, @Valid @RequestBody UserInfo requestUserInfo) {
		UserInfo userInfo =  userInfoRepository.findByuserName(userName);
		UserLoginResponseDTO userLoginResponseDTO = new UserLoginResponseDTO();
		
		if (userInfo.getOrgLevelNo() !=  5) {
			userLoginResponseDTO.setAuthStatus(false);
			userLoginResponseDTO.setComments("Only Rainbow Home Staff is allowed to login");
		}
		else if (userInfo.getPassword().equals(requestUserInfo.getPassword())) {
			userLoginResponseDTO.setAuthStatus(true);
			userLoginResponseDTO.setOrgId(userInfo.getOrgId());
		} else {
			userLoginResponseDTO.setAuthStatus(false);
			userLoginResponseDTO.setOrgId(null);
		}
		return userLoginResponseDTO;
	}

}