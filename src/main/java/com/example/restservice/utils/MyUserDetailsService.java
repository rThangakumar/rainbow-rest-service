package com.example.restservice.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.restservice.crud.UserInfo;
import com.example.restservice.repository.UserInfoRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UserInfoRepository userRepository;

	@Override
    public UserDetails loadUserByUsername(String username) {
        UserInfo user = userRepository.findByuserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }
	
}
