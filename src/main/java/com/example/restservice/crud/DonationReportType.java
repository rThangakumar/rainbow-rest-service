package com.example.restservice.crud;

import javax.persistence.*;

@Entity
@Table(name = "DonationReportType", schema = "dbo")
public class DonationReportType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DonationReportTypeId")
    private Integer donationReportTypeId;

    @Column(name = "DonationReportTypeName", nullable = false, unique = true)
    private String donationReportTypeName;

    public Integer getDonationReportTypeId() {
        return donationReportTypeId;
    }

    public void setDonationReportTypeId(Integer donationReportTypeId) {
        this.donationReportTypeId = donationReportTypeId;
    }

    public String getDonationReportTypeName() {
        return donationReportTypeName;
    }

    public void setDonationReportTypeName(String donationReportTypeName) {
        this.donationReportTypeName = donationReportTypeName;
    }
}
