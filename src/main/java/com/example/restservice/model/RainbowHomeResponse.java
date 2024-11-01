package com.example.restservice.model;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RainbowHomeResponse {
    public Integer rhNo;

    public String rhCode;

    public String rhName;

    public String city;

    public Integer status;

    public Short stateNetworkNo;
}
