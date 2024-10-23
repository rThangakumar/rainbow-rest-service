package com.example.restservice.model;

import com.example.restservice.crud.RainbowHome;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoResponse {

    private Integer userId;
    private String userName;
    private Integer orgId;
    private Integer orgLevelId;
    private RainbowHomeResponse rainbowHome;
}
