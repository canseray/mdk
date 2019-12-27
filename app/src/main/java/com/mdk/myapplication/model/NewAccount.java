package com.mdk.myapplication.model;

public class NewAccount {
    private String name;
    private String sname;
    private String email;
    private String pass;
    private String mobile;
    private String city;
    private String encrypt_password;
    private String gender;

    public NewAccount(String name, String sname, String email, String pass, String mobile, String city) {
        this.name = name;
        this.sname = sname;
        this.email = email;
        this.pass = pass;
        this.mobile = mobile;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEncrypt_password() {
        return encrypt_password;
    }

    public void setEncrypt_password(String encrypt_password) {
        this.encrypt_password = encrypt_password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
