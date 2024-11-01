package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadDonationResponse {

    @JsonProperty("leadDonationId")
    private Integer leadDonationId;

    @JsonProperty("donationAmount")
    private Double donationAmount;

    @JsonProperty("donationCycle")
    private String donationCycle;

    @JsonProperty("remarks")
    private String remarks;

    @JsonProperty("reportTypeId")
    private Integer reportTypeId;

    @JsonProperty("reportSharingFreq")
    private String reportSharingFreq;

    @JsonProperty("shareReport")
    private Boolean shareReport;

    @JsonProperty("renewDonor")
    private Boolean renewDonor;

    @JsonProperty("createdDate")
    private LocalDateTime createdDate;

    @JsonProperty("leadNo")
    private String leadNo;
}
