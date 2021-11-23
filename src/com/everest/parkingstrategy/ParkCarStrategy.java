package com.everest.parkingstrategy;

import com.everest.parkinglot.Floor;
import com.everest.parkinglot.ParkingLot;
import com.everest.parkinglot.Slot;
import com.everest.vehicle.Vehicle;

import java.util.Map;

public class ParkCarStrategy implements ParkStrategy {

    @Override
    public Vehicle unParkVehicle(String ticketId,  ParkingLot parkingLot) {
        Map<Integer,Floor> occupiedFloors=parkingLot.getOccupiedFloors("Occupied_Floors");
        if(occupiedFloors!=null){
            int floorNumber=Integer.parseInt(ticketId.split("_",-1)[1]);
            int slotNumber=Integer.parseInt(ticketId.split("_",-1)[2]);
            if(occupiedFloors.size()>=floorNumber){
               Floor floor = occupiedFloors.get(floorNumber);
                Slot slot=floor.getSlot(slotNumber);
               if(slot!=null){
                   Vehicle vehicle=slot.unParkVehicle();
                   parkingLot.setUnParkStatus(floorNumber,slotNumber);
                   return vehicle;
               }
            }
        }
        return null;
    }

    @Override
    public String parkVehicle(Vehicle vehicle,ParkingLot parkingLot) {
        Map<Integer,Floor> freeFloors = parkingLot.getFreeFloors();
        Floor floor;
        for (int i=1;i<=freeFloors.size();i++) {
            floor=freeFloors.get(i);
            for (int j = 4; j < floor.getNoOfSlots(); j++) {
                if(!floor.getSlot(j).isVehicleParked()){
                    parkingLot.setParkStatus(i,j);
                    return "PR1234_"+i+"_"+j;
                }
            }
        }
        return null;
    }
}
