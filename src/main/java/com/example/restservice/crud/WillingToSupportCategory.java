package com.example.restservice.crud;

import javax.persistence.*;

@Entity
@Table(name = "WillingToSupportCategory", schema = "dbo")
public class WillingToSupportCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WillingToSupportId")
    private Integer willingToSupportId;

    @Column(name = "CategoryName", nullable = false, unique = true)
    private String categoryName;

    // Getters and setters
    public Integer getWillingToSupportId() {
        return willingToSupportId;
    }

    public void setWillingToSupportId(Integer willingToSupportId) {
        this.willingToSupportId = willingToSupportId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
