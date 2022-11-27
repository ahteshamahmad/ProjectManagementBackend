package com.techwarriors.projectmanagementbackend.model;

import javax.persistence.*;

@Entity(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="admin_id")
    private String adminId;
    @Column(name="admin_first_name")
    private String adminFirstName;
    @Column(name="admin_last_name")
    private String adminLastName;
    @Column(name="admin_password")
    private String adminPassword;
    @Column(name="admin_phono")
    private String adminPhono;
    @Column(name="admin_email_id")
    private String adminEmailId;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminFirstName() {
        return adminFirstName;
    }

    public void setAdminFirstName(String adminFirstName) {
        this.adminFirstName = adminFirstName;
    }

    public String getAdminLastName() {
        return adminLastName;
    }

    public void setAdminLastName(String adminLastName) {
        this.adminLastName = adminLastName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminPhono() {
        return adminPhono;
    }

    public void setAdminPhono(String adminPhono) {
        this.adminPhono = adminPhono;
    }

    public String getAdminEmailId() {
        return adminEmailId;
    }

    public void setAdminEmailId(String adminEmailId) {
        this.adminEmailId = adminEmailId;
    }


}
