package com.example.restservice.service;

import com.example.restservice.crud.RainbowHome;
import com.example.restservice.model.RainbowHomeResponse;
import com.example.restservice.repository.RainbowHomeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RainbowHomeService {

    @Autowired
    private RainbowHomeRepository rainbowHomeRepository;

    private static final Logger logger = LoggerFactory.getLogger(RainbowHomeService.class);

    @Transactional(readOnly = true)
    public List<RainbowHomeResponse> getRainbowHomes(List<Short> stateNetworkNos) {
        try {
            List<RainbowHome> rainbowHomesEntity = rainbowHomeRepository.findByStateNetworkNoInAndStatus(stateNetworkNos, 1);
            if (rainbowHomesEntity.isEmpty()) {
                return Collections.emptyList();
            }
            return rainbowHomesEntity.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }catch (Exception ex) {
             logger.error("Error occurred while fetching Rainbow Homes", ex);

            throw new RuntimeException("An error occurred while fetching Rainbow Homes. Please try again later.", ex);
        }
    }

    private RainbowHomeResponse convertToDTO(RainbowHome rainbowHomeEntity) {
        return RainbowHomeResponse.builder()
                .rhNo(rainbowHomeEntity.getRhNo())
                .rhName(rainbowHomeEntity.getRhName())
                .rhCode(rainbowHomeEntity.getRhCode())
                .city(rainbowHomeEntity.getCity())
                .status(rainbowHomeEntity.getStatus())
                .stateNetworkNo(rainbowHomeEntity.getStateNetworkNo())
                .build();
    }
}
