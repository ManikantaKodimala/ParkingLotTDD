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

    public Vehicle unParkVehicle(){
        Vehicle vehicle1=this.vehicle;
        this.vehicle=null;
        return vehicle1;
    }

    public int getID() {
        return this.slotId;
    }
}
