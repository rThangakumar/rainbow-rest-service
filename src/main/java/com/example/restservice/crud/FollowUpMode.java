package com.example.restservice.crud;

import javax.persistence.*;

@Entity
@Table(name = "FollowUpMode",  schema = "dbo")
public class FollowUpMode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FollowUpModeId")
    private Integer followUpModeId;

    @Column(name = "FollowUpModeName", nullable = false, unique = true)
    private String followUpModeName;

    public String getFollowUpModeName() {
        return followUpModeName;
    }

    public void setFollowUpModeName(String followUpModeName) {
        this.followUpModeName = followUpModeName;
    }

    public Integer getFollowUpModeId() {
        return followUpModeId;
    }

    public void setFollowUpModeId(Integer followUpModeId) {
        this.followUpModeId = followUpModeId;
    }
}
