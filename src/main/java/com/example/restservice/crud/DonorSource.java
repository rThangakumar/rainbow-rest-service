package com.example.restservice.crud;

import javax.persistence.*;

@Entity
@Table(name = "DonorSource")
public class DonorSource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donor_source_id")
    private Integer donorSourceId;

    @Column(name = "donor_source_name", nullable = false)
    private String donorSourceName;

    public Integer getDonorSourceId() {
        return donorSourceId;
    }

    public void setDonorSourceId(Integer donorSourceId) {
        this.donorSourceId = donorSourceId;
    }

    public String getDonorSourceName() {
        return donorSourceName;
    }

    public void setDonorSourceName(String donorSourceName) {
        this.donorSourceName = donorSourceName;
    }
}


