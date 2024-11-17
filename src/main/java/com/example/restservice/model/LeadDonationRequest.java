package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadDonationRequest {

    @JsonProperty("donationAmount")
    private Double donationAmount;

    @JsonProperty("donationCycle")
    private String donationCycle;

    @JsonProperty("remarks")
    private String remarks;

    @JsonProperty("quarterlyReportTypeId")
    private Integer quarterlyReportTypeId; // FK

    @JsonProperty("halfYearlyReportTypeId")
    private Integer halfYearlyReportTypeId; // FK

    @JsonProperty("yearlyReportTypeId")
    private Integer yearlyReportTypeId; // FK

    @JsonProperty("shareReport")
    private Boolean shareReport;

    @JsonProperty("renewDonor")
    private Boolean renewDonor;

    @JsonProperty("leadNo")
    private String leadNo; //FK

}
