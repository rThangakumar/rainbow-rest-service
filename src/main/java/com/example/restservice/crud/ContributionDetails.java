package com.example.restservice.crud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ContributionDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContributionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ContributionNo")
    private Integer contributionNo;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "RHNo")
//    private RainbowHome rainbowHome;
    @Column(name = "RHNo")
    private Integer rhNo;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "SponsorTypeID")
//    private SponsorType sponsorType;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "SponsorshipTypeID")
//    private SponsorshipType sponsorshipType;

//    @Column(name = "SponsorTypeID")
//    private Integer sponsorTypeId;

    @Column(name = "SponsorshipTypeID")
    private Integer sponsorshipTypeId;


    @Column(name = "SponsorName", length = 250, nullable = true)
    private String sponsorName;

    @Column(name = "ContributionDate", nullable = true)
    private String contributionDate;

    @Column(name = "InkindID", nullable = true)
    private Integer inkindID;

    @Column(name = "Quantity", nullable = true)
    private Integer quantity;

    @Column(name = "Amount", precision = 18, scale = 2, nullable = true)
    private Double amount;

    @Column(name = "Created_On", updatable = false, nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "Created_By", nullable = true)
    private Integer createdBy;

    @Column(name = "Modified_By", nullable = true)
    private Integer modifiedBy;

    @Column(name = "Modified_On", nullable = false)
    private LocalDateTime modifiedOn;

    @Column(name = "Status", nullable = true, columnDefinition = "bit default 1")
    private Boolean status;

    @Column(name = "DonationReasonId")
    private Integer donationReasonId;

    @Column(name = "DonationOccasion")
    private String donationOccasion;

    @Column(name = "ProgramTypeId")
    private Integer programTypeId;

    @Column(name = "DonorPreferenceId")
    private Integer donorPreferenceId;

    @Column(name = "SponsorId")
    private Integer sponsorId;

    @Column(name = "BudgetedFromDonation")
    private double budgetedFromDonation;

    @Column(name = "UnBudgetedFromDonation")
    private double unBudgetedFromDonation;

    @Column(name = "SpecialDayDate")
    private LocalDate specialDayDate;

    @Column(name = "DonationPurposeId")
    private Integer donationPurposeId;
}




