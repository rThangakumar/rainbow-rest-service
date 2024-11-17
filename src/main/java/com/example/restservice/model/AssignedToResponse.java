package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AssignedToResponse {
    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("userName")
    private String userName;

}
