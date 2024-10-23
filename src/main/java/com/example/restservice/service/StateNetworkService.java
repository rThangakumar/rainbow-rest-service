package com.example.restservice.service;

import com.example.restservice.crud.StateNetwork;
import com.example.restservice.model.StateNetworkResponse;
import com.example.restservice.repository.StateNetworkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateNetworkService {
    @Autowired
    private StateNetworkRepository stateNetworkRepository;

    private static final Logger logger = LoggerFactory.getLogger(StateNetworkService.class);

    @Transactional(readOnly = true)
    public List<StateNetworkResponse> getAllStateNetworks() {
        try {
            List<StateNetwork> stateNetworksEntity = stateNetworkRepository.findAll();
            return stateNetworksEntity.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            logger.error("Error in fetching state networks", ex);
            throw new RuntimeException("Error in fetching state networks", ex);
        }
    }

    @Transactional(readOnly = true)
    public StateNetworkResponse getStateNetworkById(Short stateNetworkNo) {
        StateNetwork stateNetworkEntity = stateNetworkRepository.findByStateNetworkNo(stateNetworkNo)
                .orElseThrow(() -> new RuntimeException("StateNetwork not found for the given StateNetworkNo"));

        return convertToDTO(stateNetworkEntity);
    }

    private StateNetworkResponse convertToDTO(StateNetwork stateNetworkEntity) {
        return StateNetworkResponse.builder()
                .stateNetworkNo(stateNetworkEntity.getStateNetworkNo())
                .stateNetworkName(stateNetworkEntity.getStateNetworkName())
                .stateNetworkCode(stateNetworkEntity.getStateNetworkCode())
                .build();
    }
}
