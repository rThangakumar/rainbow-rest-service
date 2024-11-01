package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowUpRequest {

    @JsonProperty("assignedTo")
    private String assignedTo;

    @JsonProperty("modeId")
    private Integer modeId; // FK

    @JsonProperty("remarks")
    private String remarks;

    @JsonProperty("followUpDate")
    private LocalDate followUpDate;

    @JsonProperty("leadNo")
    private String leadNo;

}
