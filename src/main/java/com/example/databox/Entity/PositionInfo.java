package com.example.databox.Entity;

public class PositionInfo {
    private Integer PositionID;
    private String Position;
    private String Salary;
    private String Description;
    private String CompanyName;
    private String Function;


    public Integer getPositionID() {
        return PositionID;
    }

    public void setPositionID(Integer positionID) {
        PositionID = positionID;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

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

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getFunction() {
        return Function;
    }

    public void setFunction(String function) {
        Function = function;
    }
}
