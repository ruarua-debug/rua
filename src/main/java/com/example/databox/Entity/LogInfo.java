package com.example.databox.Entity;

import javax.xml.crypto.Data;
import java.util.Date;

public class LogInfo {
    private Integer LogID;
    private Integer UserID;
    private String IP_Address;
    private String OS;
    private String IE;
    private Date CreatDate;
    private String UserName;

    public Integer getLogID() {
        return LogID;
    }

    public void setLogID(Integer logID) {
        LogID = logID;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public String getIP_Address() {
        return IP_Address;
    }

    public void setIP_Address(String IP_Address) {
        this.IP_Address = IP_Address;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public Date getCreatDate() {
        return CreatDate;
    }

    public void setCreatDate(Date creatDate) {
        CreatDate = creatDate;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
