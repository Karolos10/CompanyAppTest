package com.companyApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompany;

    @Column(unique = true, nullable = false)
    private String codeCompany;

    private String nameCompany;

    private String descripcionCompany;

    public Company() {
    }

    public Company(Long idCompany, String codeCompany, String nameCompany, String descripcionCompany) {
        this.idCompany = idCompany;
        this.codeCompany = codeCompany;
        this.nameCompany = nameCompany;
        this.descripcionCompany = descripcionCompany;
    }

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    public String getCodeCompany() {
        return codeCompany;
    }

    public void setCodeCompany(String codeCompany) {
        this.codeCompany = codeCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getDescripcionCompany() {
        return descripcionCompany;
    }

    public void setDescripcionCompany(String descripcionCompany) {
        this.descripcionCompany = descripcionCompany;
    }
}
