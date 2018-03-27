package com.example.admin.examone.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 23-02-2018.
 */

public class SocialData {
    String fullName;
    String pic;
    String username;
    String time;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public SocialData(){}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SocialData(String fullName, String pic, String username,String time) {

        this.fullName = fullName;
        this.pic = pic;
        this.username = username;
        this.time=time;
    }
}
