package com.example.databox.Entity;

public class ViewUser {
    private Integer UserID;
    private String UserName;
    private String UserPhone;
    private String Password;
    private String User_image_url;

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUser_image_url() {
        return User_image_url;
    }

    public void setUser_image_url(String user_image_url) {
        User_image_url = user_image_url;
    }
}

