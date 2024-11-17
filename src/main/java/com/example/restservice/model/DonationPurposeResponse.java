package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DonationPurposeResponse {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("purposeName")
    private String purposeName;

    @JsonProperty("isDefault")
    private boolean isDefault;

    @JsonProperty("createdBy")
    private Integer createdBy;

    @JsonProperty("createdOn")
    private LocalDateTime createdOn;
}
