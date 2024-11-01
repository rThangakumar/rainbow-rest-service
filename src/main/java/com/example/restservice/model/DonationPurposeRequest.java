package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DonationPurposeRequest {
    @JsonProperty("purposeName")
    private String purposeName;

    @JsonProperty("isDefault")
    private Boolean isDefault = true;

    @JsonProperty("createdBy")
    private Integer createdBy;
}
