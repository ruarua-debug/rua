package com.example.databox.Entity;

public class MessageInfo {
    private Integer CommessageID;
    private String CompanyName;
    private String CompanySign;
    private String CompanySize;
    private String BaseInformation;
    private String BusinessInformation;
    private String City;
    private String CompanyAddress;
    private String CompanyMap;
    private String CompanyLogo;
    private String CompanyLabel;
    private String Position;
    private String Salary;

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    private String Description;



    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }


    public Integer getCommessageID() {
        return CommessageID;
    }

    public void setCommessageID(Integer commessageID) {
        CommessageID = commessageID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getCompanySign() {
        return CompanySign;
    }

    public void setCompanySign(String companySign) {
        CompanySign = companySign;
    }

    public String getCompanySize() {
        return CompanySize;
    }

    public void setCompanySize(String companySize) {
        CompanySize = companySize;
    }

    public String getBaseInformation() {
        return BaseInformation;
    }

    public void setBaseInformation(String baseInformation) {
        BaseInformation = baseInformation;
    }

    public String getBusinessInformation() {
        return BusinessInformation;
    }

    public void setBusinessInformation(String businessInformation) {
        BusinessInformation = businessInformation;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCompanyAddress() {
        return CompanyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        CompanyAddress = companyAddress;
    }

    public String getCompanyMap() {
        return CompanyMap;
    }

    public void setCompanyMap(String companyMap) {
        CompanyMap = companyMap;
    }

    public String getCompanyLogo() {
        return CompanyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        CompanyLogo = companyLogo;
    }

    public String getCompanyLabel() {
        return CompanyLabel;
    }

    public void setCompanyLabel(String companyLabel) {
        CompanyLabel = companyLabel;
    }
}

