package com.example.pkiProject.user;

public class User {

    String name;
    String address;
    String phone;
    String username;
    String pasword;

    public User(String name, String address, String phone, String username, String pasword) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.username = username;
        this.pasword = pasword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
