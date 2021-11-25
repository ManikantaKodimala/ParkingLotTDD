package com.everest.display;

import com.everest.parkinglot.ParkingLot;

public class DisplayStrategy {
    public  static void displayHandler(String vehicleType, String displayType, ParkingLot parkingLot){
        Display display;
        switch (vehicleType){
            case "CAR":
                display = new DisplayCarSlot();
                display.displayHandler(displayType,parkingLot);
                break;
            case "BIKE":
                display= new DisplayBikeSlots();
                display.displayHandler(displayType,parkingLot);
                break;
            case "TRUCK":
                display= new DisplayTruckSlots();
                display.displayHandler(displayType,parkingLot);
                break;
        }
    }
}
