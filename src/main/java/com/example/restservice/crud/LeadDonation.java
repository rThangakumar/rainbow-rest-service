package com.example.restservice.crud;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LeadDonationTable")
@Data
@Builder
public class LeadDonation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LeadDonationId", nullable = false, unique = true)
    private Integer leadDonationId;

    @Column(name = "DonationAmount", nullable = false, precision = 18, scale = 2)
    private Double donationAmount;

    @Column(name = "DonationCycle", nullable = false)
    private String donationCycle;

    @Column(name = "Remarks", length = 500)
    private String remarks;

    @Column(name = "QuarterlyReportTypeId", nullable = false)
    private Integer quarterlyReportTypeId;  // Foreign key to ReportType table

    @Column(name = "HalfYearlyReportTypeId", nullable = false)
    private Integer halfYearlyReportTypeId;  // Foreign key to ReportType table

    @Column(name = "YearlyReportTypeId", nullable = false)
    private Integer yearlyReportTypeId;  // Foreign key to ReportType table

    @Column(name = "ShareReport", nullable = false)
    private Boolean shareReport;

    @Column(name = "RenewDonor", nullable = false)
    private Boolean renewDonor;

    @Column(name = "CreatedDate", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "LeadNo", nullable = false, unique = true, length = 50)
    private String leadNo;
}

