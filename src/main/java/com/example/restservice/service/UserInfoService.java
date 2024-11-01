package com.example.restservice.service;

import com.example.restservice.crud.RainbowHome;
import com.example.restservice.crud.UserInfo;
import com.example.restservice.model.RainbowHomeResponse;
import com.example.restservice.model.UserInfoResponse;
import com.example.restservice.repository.RainbowHomeRepository;
import com.example.restservice.repository.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private RainbowHomeRepository rainbowHomeRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    @Transactional(readOnly = true)
    public UserInfoResponse getUserInfo(Integer userId) {
        try {
            UserInfo userInfoEntity = userInfoRepository.findByUserNo(userId)
                    .orElseThrow(() -> new RuntimeException("UserInfo not found for the given userId"));

            Integer orgId = userInfoEntity.getOrgId();
            RainbowHome rainbowHomeEntity = rainbowHomeRepository.findByrhNo(orgId)
                    .orElseThrow(() -> new RuntimeException("RainbowHome not found for the given orgId"));

            // converting from entity to response
            UserInfoResponse userInfoResponse = convertToDTO(userInfoEntity);
            userInfoResponse.setRainbowHome(convertToDTO(rainbowHomeEntity));
            return userInfoResponse;
        }catch (Exception ex) {
            logger.error("Error occurred while fetching User info", ex);

            throw new RuntimeException("An error occurred while fetching User info. Please try again later.", ex);
        }
    }

    private UserInfoResponse convertToDTO(UserInfo userInfoEntity) {
        return UserInfoResponse.builder()
                .userId(userInfoEntity.getUserNo())
                .userName(userInfoEntity.getUserName())
                .orgId(userInfoEntity.getOrgId())
                .orgLevelId(userInfoEntity.getOrgLevelNo())
                .build();
    }

    private RainbowHomeResponse convertToDTO(RainbowHome rainbowHome) {
        // Convert RainbowHome to RainbowHomeResponse
        return RainbowHomeResponse.builder()
                .rhNo(rainbowHome.getRhNo())
                .rhName(rainbowHome.getRhName())
                .rhCode(rainbowHome.getRhCode())
                .stateNetworkNo(rainbowHome.getStateNetworkNo())
                .status(rainbowHome.getStatus())
                .city(rainbowHome.getCity())
                .build();
    }

}
