package com.bhavyakaria.low_level_design.parkinglotsystem.models;

import com.bhavyakaria.low_level_design.parkinglotsystem.enums.Status;

import java.util.List;

public class Building {
    public int number;
    public String name;
    public List<Floor> floors;
    public Status status;

    public Building(int number, String name, List<Floor> floors, Status status) {
        this.number = number;
        this.name = name;
        this.floors = floors;
        this.status = status;
    }


}
