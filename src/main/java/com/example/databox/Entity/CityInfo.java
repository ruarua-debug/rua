package com.example.databox.Entity;

public class CityInfo {
    private Integer CityID;
    private String City;
    private String Position;
    private String Description;
    private String Company;
    private String Salary;
    private String Image;
    private String Link;



    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
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

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
