package com.everest.display;

import com.everest.parkinglot.ParkingLot;

public interface Display {
    void displayHandler(String displayType,ParkingLot parkingLot);
    void displayFreeSlots(ParkingLot parkingLot);
    void displayFreeSlotsCount(ParkingLot parkingLot);
    void displayOccupiedSlots(ParkingLot parkingLot);
}
