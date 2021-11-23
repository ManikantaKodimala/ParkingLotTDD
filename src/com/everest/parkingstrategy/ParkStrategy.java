package com.everest.parkingstrategy;

import com.everest.parkinglot.ParkingLot;
import com.everest.vehicle.Vehicle;

public interface ParkStrategy {
    public Vehicle unParkVehicle(String ticketId, ParkingLot parkingLot);
    public  String parkVehicle(Vehicle vehicle, ParkingLot parkingLot);
}
