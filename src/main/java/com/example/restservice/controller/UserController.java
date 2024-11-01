package com.example.restservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/user-login")
	public UserLoginResponseDTO getUserLogin(@Valid @RequestBody UserInfo requestUserInfo) {
		UserInfo userInfo =  userInfoRepository.findByuserName(requestUserInfo.getUserName());
		System.out.println(userInfo);
		UserLoginResponseDTO userLoginResponseDTO = new UserLoginResponseDTO();
		if (null == userInfo) {
			userLoginResponseDTO.setAuthStatus(false);
			userLoginResponseDTO.setComments("The User Name doesn't exist");
			return userLoginResponseDTO;
		} else {
//			if (null!= userInfo.getOrgLevelNo() && userInfo.getOrgLevelNo() !=  5) {
//				userLoginResponseDTO.setAuthStatus(false);
//				userLoginResponseDTO.setComments("Please use Home Staff ID to login");
//			}
			if (userInfo.getPassword().equals(requestUserInfo.getPassword())) {
				userLoginResponseDTO.setAuthStatus(true);
				userLoginResponseDTO.setOrgId(userInfo.getOrgId());
				userLoginResponseDTO.setOrgLevelNo(userInfo.getOrgLevelNo());
				userLoginResponseDTO.setHomeCode(userInfo.getRainbowHome().getRhCode());
				userLoginResponseDTO.setUserId(userInfo.getUserNo());
				userLoginResponseDTO.setComments("Authentication successful");
			} else {
				userLoginResponseDTO.setAuthStatus(false);
				userLoginResponseDTO.setOrgId(null);
				userLoginResponseDTO.setComments("Password is incorrect");
			}
			return userLoginResponseDTO;
		}
		
	}

}