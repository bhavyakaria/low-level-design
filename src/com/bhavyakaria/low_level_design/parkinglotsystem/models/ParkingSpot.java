package com.bhavyakaria.low_level_design.parkinglotsystem.models;

import com.bhavyakaria.low_level_design.parkinglotsystem.enums.Status;

public class ParkingSpot {
    public int id;
    public boolean isAvailable;
    public Status status;

    public ParkingSpot(int id, boolean isAvailable, Status status) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.status = status;
    }

    public void setAvailable(boolean val) {
        this.isAvailable = val;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", isAvailable=" + isAvailable +
                ", status=" + status +
                '}';
    }
}
