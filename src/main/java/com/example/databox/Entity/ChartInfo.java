package com.example.databox.Entity;

public class ChartInfo {
    private Integer CityID;
    private Integer PositionID;
    private String City;
    private String Position;
    private String Description;
    private String Company;
    private Integer MinSalary;
    private Integer MaxSalary;
    private Integer AvgSalary;
    private String Education;
    private String Experience;
    private Integer Number;
    private Integer Salary;

    public Integer getPositionID() {
        return PositionID;
    }

    public void setPositionID(Integer positionID) {
        PositionID = positionID;
    }

    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer salary) {
        Salary = salary;
    }

    public Integer getCityID() {
        return CityID;
    }

    public void setCityID(Integer cityID) {
        CityID = cityID;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public Integer getMinSalary() {
        return MinSalary;
    }

    public void setMinSalary(Integer minSalary) {
        MinSalary = minSalary;
    }

    public Integer getMaxSalary() {
        return MaxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        MaxSalary = maxSalary;
    }

    public Integer getAvgSalary() {
        return AvgSalary;
    }

    public void setAvgSalary(Integer avgSalary) {
        AvgSalary = avgSalary;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String experience) {
        Experience = experience;
    }

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }
}
