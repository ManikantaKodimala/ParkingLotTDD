package com.everest.parkingstrategy;

import com.everest.vehicle.Vehicle;

public interface ParkStrategy {
    public Vehicle unParkVehicle(String ticketId);
    public  String parkVehicle(Vehicle vehicle);
}
