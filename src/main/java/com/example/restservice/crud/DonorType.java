package com.example.restservice.crud;

import javax.persistence.*;

@Entity
@Table(name = "DonorType")
public class DonorType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "donor_type_name", nullable = false)
    private String donorTypeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDonorTypeName() {
        return donorTypeName;
    }

    public void setDonorTypeName(String typeName) {
        this.donorTypeName = typeName;
    }
}

