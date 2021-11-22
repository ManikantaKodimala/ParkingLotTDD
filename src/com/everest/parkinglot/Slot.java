package com.everest.parkinglot;

import com.everest.vehicle.Vehicle;

public class Slot {
    private int slotId;
    private Vehicle vehicle;
    private String ticketId;

    public Slot(int slotId) {
        this.slotId = slotId;
    }

    public void parkVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
    }

    public boolean isVehicleParked(){
        return this.vehicle!=null;
    }

    public void unParkVehicle(){
        this.vehicle=null;
    }
}
