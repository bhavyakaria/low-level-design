package com.bhavyakaria.low_level_design.parkinglotsystem.models;

public class User {
    public String name;
    public String address;
    public String mobileNumber;
    public String email;

    public User(String name, String address, String mobileNumber, String email) {
        this.name = name;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }
}
