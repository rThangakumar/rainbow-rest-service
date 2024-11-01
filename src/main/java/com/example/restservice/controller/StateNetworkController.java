package com.example.restservice.controller;

import com.example.restservice.model.StateNetworkResponse;
import com.example.restservice.service.StateNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/stateNetwork")
public class StateNetworkController {

    @Autowired
    private StateNetworkService stateNetworkService;

    @GetMapping
    public List<StateNetworkResponse> getAllStateNetworks() {
        return stateNetworkService.getAllStateNetworks();
    }

    @GetMapping("/{stateNetworkNo}")
    public StateNetworkResponse getStateNetworkById(@PathVariable Short stateNetworkNo) {
        return stateNetworkService.getStateNetworkById(stateNetworkNo);
    }
}
