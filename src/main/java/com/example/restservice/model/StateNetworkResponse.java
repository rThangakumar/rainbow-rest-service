package com.example.restservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StateNetworkResponse {
    private Short stateNetworkNo;
    private String stateNetworkName;
    private String stateNetworkCode;
}
