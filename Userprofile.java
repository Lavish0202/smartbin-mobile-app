package com.lavish.smartbin;

public class Userprofile {
    public String username;
    public String aadharnum;
    public String email;
    public Userprofile(){


    }

    public Userprofile(String username,String aadharnum , String email) {
        this.username = username;
        this.aadharnum = aadharnum;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAadharnum() {
        return aadharnum;
    }

    public void setAadharnum(String aadharnum) {
        this.aadharnum = aadharnum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
