package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class ContributionRequest {
    @JsonProperty("rhNos")
    private Integer[] rHNos;

    @JsonProperty("sponsorshipTypeID")
    private Integer sponsorshipTypeID;

    @JsonProperty("sponsorName")
    private String sponsorName;

    @JsonProperty("contributionDate")
    private String contributionDate;

    @JsonProperty("inkindId")
    private Integer inkindId;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("createdOn")
    private LocalDateTime createdOn;

    @JsonProperty("createdBy")
    private Integer createdBy;

    @JsonProperty("modifiedBy")
    private Integer modifiedBy;

    @JsonProperty("modifiedOn")
    private LocalDateTime modifiedOn;

    @JsonProperty("donationReasonId")
    private Integer donationReasonId;

    @JsonProperty("donationOccasion")
    private String donationOccasion;

    @JsonProperty("programTypeId")
    private Integer programTypeId;

    @JsonProperty("donorPreferenceId")
    private Integer donorPreferenceId;

    @JsonProperty("sponsorId")
    private Integer sponsorId;

    @JsonProperty("budgetedFromDonation")
    private double budgetedFromDonation;

    @JsonProperty("unBudgetedFromDonation")
    private double unBudgetedFromDonation;

    @JsonProperty("specialDayDate")
    private LocalDate specialDayDate;

    @JsonProperty("donationPurposeId")
    private Integer donationPurposeId;
}
