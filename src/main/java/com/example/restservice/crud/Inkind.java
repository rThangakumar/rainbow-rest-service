package com.example.restservice.crud;


import javax.persistence.*;

@Entity
@Table(name = "Inkind",  schema = "dbo")
public class Inkind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InkindID")
    private Integer id;


    @Column(name = "InkindName", nullable = false)
    private String inkindName;


    @Column(name = "status", nullable = false)
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInkindName() {
        return inkindName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setInkindName(String inkindName) {
        this.inkindName = inkindName;
    }
}
