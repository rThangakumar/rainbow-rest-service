package com.example.restservice.crud;

import javax.persistence.*;

@Entity
@Table(name = "LeadOrganisationType", schema = "dbo")
public class LeadOrganisationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "LeadOrgTypeName", nullable = false, unique = true)
    private String leadOrgTypeName;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeadOrgTypeName() {
        return leadOrgTypeName;
    }

    public void setLeadOrgTypeName(String leadOrgTypeName) {
        this.leadOrgTypeName = leadOrgTypeName;
    }
}
