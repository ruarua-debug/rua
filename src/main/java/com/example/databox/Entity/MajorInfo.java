package com.example.databox.Entity;

public class MajorInfo {
    private Integer MajorID;
    private String Major;
    private String Position;
    private String Description;
    private String City;
    private String Salary;
    private String Image;
    private String Link;

    public Integer getMajorID() {
        return MajorID;
    }

    public void setMajorID(Integer majorID) {
        MajorID = majorID;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
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

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
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

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
