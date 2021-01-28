package com.example.databox.Entity;

import java.sql.Date;

public class AdminInfo {
    private Integer AdminID;
    private String AdminName;
    private String AdminPhone;
    private String AdminPassword;
    private String Admin_image_url;

    public Integer getAdminID() {
        return AdminID;
    }

    public void setAdminID(Integer adminID) {
        AdminID = adminID;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public String getAdminPhone() {
        return AdminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        AdminPhone = adminPhone;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        AdminPassword = adminPassword;
    }

    public String getAdmin_image_url() {
        return Admin_image_url;
    }

    public void setAdmin_image_url(String admin_image_url) {
        Admin_image_url = admin_image_url;
    }
}