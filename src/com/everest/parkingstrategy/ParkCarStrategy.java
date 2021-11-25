package com.everest.parkingstrategy;

import com.everest.parkinglot.Floor;
import com.everest.parkinglot.ParkingLot;
import com.everest.parkinglot.Slot;
import com.everest.parkinglot.util.Parking;
import com.everest.vehicle.Vehicle;

import java.util.Map;

public class ParkCarStrategy implements ParkStrategy {

    private int slotStartsAt= 4;
    private int slotEndsAt;
    @Override
    public Vehicle unParkVehicle(String ticketId,  ParkingLot parkingLot) {
        Map<Integer,Floor> occupiedFloors=parkingLot.getOccupiedFloors();
        if(occupiedFloors!=null){
            int floorNumber=Integer.parseInt(ticketId.split("_",-1)[1]);
            int slotNumber=Integer.parseInt(ticketId.split("_",-1)[2]);
            if(occupiedFloors.size()>=floorNumber){
               Floor floor = occupiedFloors.get(floorNumber);
                Slot slot=floor.getSlot(slotNumber);
               if(slot!=null){
                   Vehicle vehicle=slot.unParkVehicle();
                   setUnParkStatus(floorNumber,slotNumber,parkingLot.getFreeFloors(),occupiedFloors);
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
            for (int j = slotStartsAt; j <=floor.getNoOfSlots(); j++) {
                System.out.println("j="+j+" floor contains  "+floor.getSlotkeys().contains(j));
                if( floor.getSlotkeys().contains(j) &&!floor.getSlot(j).isVehicleParked()){
                    setParkStatus(i,j,floor.getNoOfSlots(),parkingLot.getFreeFloors(),parkingLot.getOccupiedFloors());
                    return "PR1234_"+i+"_"+j;
                }
            }
        }
        return null;
    }


    public void setParkStatus(int floorNumber, int slotNumber,int noOfSlots,Map<Integer,Floor> freeFloors,Map<Integer,Floor> occupiedFloors) {
        Slot removedSlot = freeFloors.get(floorNumber).removeFreeSlot(slotNumber);
        if(!occupiedFloors.containsKey(floorNumber)){
            Floor floor = new Floor(floorNumber,noOfSlots);
            occupiedFloors.put(floorNumber,floor);
        }
        Floor floor = occupiedFloors.get(floorNumber);
        floor.setFloor(floorNumber,removedSlot);
    }

    public void setUnParkStatus(int floorNumber, int slotNumber,Map<Integer,Floor> freeFloors,Map<Integer,Floor> occupiedFloors) {
        Slot removedSlot = occupiedFloors.get(floorNumber).removeFreeSlot(slotNumber);
        Floor floor = freeFloors.get(floorNumber);
        floor.setFloor(floorNumber,removedSlot);
    }
}
