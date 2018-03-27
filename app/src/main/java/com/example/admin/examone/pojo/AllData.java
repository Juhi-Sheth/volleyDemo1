package com.example.admin.examone.pojo;

/**
 * Created by Admin on 23-02-2018.
 */

public class AllData {

    String img,fname,lname,position,company,time;

    public AllData(){}

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public AllData(String img, String fname, String lname, String position, String company, String time) {

        this.img = img;
        this.fname = fname;
        this.lname = lname;
        this.position = position;
        this.company = company;
        this.time = time;
    }
}
