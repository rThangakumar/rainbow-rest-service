package com.example.restservice.crud;

import javax.persistence.*;

@Entity
@Table(name = "DonationReason", schema = "dbo")
public class DonationReason {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer donationReasonId;

    @Column(name = "reason_name")
    private String donationReasonName;


    public Integer getDonationReasonId() {
        return donationReasonId;
    }

    public void setDonationReasonId(Integer donationReasonId) {
        this.donationReasonId = donationReasonId;
    }

    public String getDonationReasonName() {
        return donationReasonName;
    }

    public void setDonationReasonName(String donationReasonName) {
        this.donationReasonName = donationReasonName;
    }


}



