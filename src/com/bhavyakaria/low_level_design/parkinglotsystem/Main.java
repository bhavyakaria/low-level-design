package com.bhavyakaria.low_level_design.parkinglotsystem;

import com.bhavyakaria.low_level_design.parkinglotsystem.enums.Key;
import com.bhavyakaria.low_level_design.parkinglotsystem.enums.VehicleType;
import com.bhavyakaria.low_level_design.parkinglotsystem.models.*;
import com.bhavyakaria.low_level_design.parkinglotsystem.services.ParkingLotService;

public class Main {

    public static void main(String[] args) {

        int NO_OF_FLOORS = 10;
        int NO_OF_PARKING_SPOTS_PER_FLOOR = 5;

        ParkingLotService parkingLotService = new ParkingLotService(NO_OF_FLOORS, NO_OF_PARKING_SPOTS_PER_FLOOR);


        User user1 = new User("Bhavya", "XYA, Borivali", "1234567898", "bhavyankaria@mgial.com");
        User user2 = new User("Raj", "XYA, Andheri", "1234567898", "raj@mgial.com");
        User user3 = new User("Manish", "XYA, CST", "1234567898", "manish@mgial.com");

        Vehicle car1 = new Vehicle(VehicleType.FOUR_WHEELER, "Maruti XYA", user1, "MH12-RA2019-AP0092", "Red");
        Vehicle car2 = new Vehicle(VehicleType.FOUR_WHEELER, "Honda", user2, "MH02-RA2019-FG2312", "Blue");
        Vehicle car3 = new Vehicle(VehicleType.FOUR_WHEELER, "Ferrai", user3, "MH03-RA2039-FG2312", "Blue");
        Vehicle car4 = new Vehicle(VehicleType.FOUR_WHEELER, "BMW", user3, "MH03-RA2039-FG2312", "Red");

        System.out.println("Available Parking Spots: "+parkingLotService.availableParkingSpotsOnAFloor(1));

        parkingLotService.park(car4);
        parkingLotService.park(car4);
        parkingLotService.park(car3);
        parkingLotService.park(car1);
        parkingLotService.park(car2);
        parkingLotService.park(car4);

        System.out.println("Available Parking Spots On Floor 1: "+parkingLotService.availableParkingSpotsOnAFloor(1));

        parkingLotService.unPark(car1);

        System.out.println("Available Parking Spots On Floor 1: "+parkingLotService.availableParkingSpotsOnAFloor(1));

        parkingLotService.getFloorAnalytics(1, Key.COLOR, "Red");
        parkingLotService.getFloorAnalytics(1, Key.BRAND, "Honda");
        parkingLotService.getFloorAnalytics(1, Key.BRAND, "BMW");

    }
}


/**
 * Output:
 * Available Parking Spots: 5
 * Available Parking Spots On Floor 1: 0
 * Available Parking Spots On Floor 1: 1
 * Count Of Red Vehicles On Floor 1 : 3
 * Count Of Honda Vehicles On Floor 1 : 1
 * Count Of BMW Vehicles On Floor 1 : 2
 * **/
