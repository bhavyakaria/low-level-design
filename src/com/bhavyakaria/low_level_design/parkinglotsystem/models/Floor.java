package com.bhavyakaria.low_level_design.parkinglotsystem.models;

import com.bhavyakaria.low_level_design.parkinglotsystem.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    public int number;
    public List<ParkingSpot> parkingSpots = new ArrayList<>();
    public Status status;

    public Floor(int number) {
        this.number = number;
    }

    public void addParkingSpot(int num) {
        ParkingSpot parkingSpot = new ParkingSpot(num, true, Status.OPEN);
        this.parkingSpots.add(parkingSpot);
    }

    public ParkingSpot getEmptyParkingSpot() {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isAvailable) {
                parkingSpot.setAvailable(false);
                return parkingSpot;
            }
        }
        return null;
    }

    public int countOfParkingSpotsAvailable() {
        int count = 0;
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isAvailable) {
                count++;
            }
        }
        return count;
    }
}
