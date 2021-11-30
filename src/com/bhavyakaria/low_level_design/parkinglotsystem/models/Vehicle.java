package com.bhavyakaria.low_level_design.parkinglotsystem.models;

import com.bhavyakaria.low_level_design.parkinglotsystem.enums.VehicleType;

public class Vehicle {
    public VehicleType vehicleType;
    public String name;
    public User user;
    public String registrationNumber;
    public String color;

    public Vehicle(VehicleType vehicleType, String name, User user, String registrationNumber, String color) {
        this.vehicleType = vehicleType;
        this.name = name;
        this.user = user;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }
}
