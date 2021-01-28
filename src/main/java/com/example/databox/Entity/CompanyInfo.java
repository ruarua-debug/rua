package com.example.databox.Entity;

public class CompanyInfo {
    private Integer PositionID;
    private String Company;
    private String Url;
    private String Position;
    private String City;
    private String Description;
    private String Education;
    private String Function;
    private String Experience;
    private String c_password;
    private boolean c_status;
    private String Email;
    private String Salary;

    public Integer getPositionID() {
        return PositionID;
    }

    public void setPositionID(Integer positionID) {
        PositionID = positionID;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getFunction() {
        return Function;
    }

    public void setFunction(String function) {
        Function = function;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String experience) {
        Experience = experience;
    }

    public String getC_password() {
        return c_password;
    }

    public void setC_password(String c_password) {
        this.c_password = c_password;
    }

    public boolean isC_status() {
        return c_status;
    }

    public void setC_status(boolean c_status) {
        this.c_status = c_status;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }
}
