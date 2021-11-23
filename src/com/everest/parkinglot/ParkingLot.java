package com.everest.parkinglot;

import com.everest.parkingstrategy.ParkBikeStrategy;
import com.everest.parkingstrategy.ParkCarStrategy;
import com.everest.parkingstrategy.ParkStrategy;
import com.everest.parkingstrategy.ParkTruckStrategy;
import com.everest.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private  int noOfSlots;
    private String parkingLotId;
    private  int noOfFloors;
    private Map<String, Map<Integer,Floor>> floorMap;

    public ParkingLot(String parkingLotId,int noOfFloors,int noOfSlots){
        this.parkingLotId = parkingLotId;
        this.noOfFloors= noOfFloors;
        this.noOfSlots=noOfSlots;
        floorMap= new HashMap<String,Map<Integer,Floor>>();
        this.createParkingLot();
    }

    private void createParkingLot() {
        Map<Integer,Floor> floor= new HashMap<>();
        for(int i=1;i<this.noOfFloors;i++){
            floor.put(i,new Floor(i,this.noOfSlots));
        }
        floorMap.put("Free_Floors",floor);
        floorMap.put("Occupied_Floors",new HashMap<>());
    }

    public String parkVehicle(Vehicle vehicle) {
        ParkStrategy strategy= this.getStrategy(vehicle.getVehicleType());
        return strategy.parkVehicle(vehicle,this);
    }

    public Vehicle unParkVehicle(String ticketId) {
        ParkStrategy strategy= this.getStrategy(ticketId);
        return strategy.unParkVehicle(ticketId,this);
    }

    private ParkStrategy getStrategy(String vehicleType) {
        switch (vehicleType){
            case "CAR":
                return new ParkCarStrategy();
            case "TRUCK":
                return new ParkTruckStrategy();
            case "BIKE":
                return new ParkBikeStrategy();
            default:
                return null;
        }
    }

    public Map<Integer,Floor> getOccupiedFloors(String occupied_floors) {
        return  this.floorMap.get("Occupied_Floors");
    }

    public void setUnParkStatus(int floorNumber, int slotNumber) {
        Slot removedSlot = this.floorMap.get("Occupied_Floors").get(floorNumber).removeFreeSlot(slotNumber);
        Map<Integer,Floor> freeFloors = this.floorMap.get("Free_Floors");
        Floor floor = freeFloors.get(floorNumber);
        floor.setFloor(floorNumber,removedSlot);
    }

    public Map<Integer,Floor> getFreeFloors() {
        return this.floorMap.get("Free_Floors");
    }

    public void setParkStatus(int floorNumber, int slotNumber) {
        Slot removedSlot = this.floorMap.get("Free_Floors").get(floorNumber).removeFreeSlot(slotNumber);
        Map<Integer,Floor> occupiedFloors = this.floorMap.get("Occupied_Floors");
        if(!occupiedFloors.containsKey(floorNumber)){
            Floor floor = new Floor(floorNumber,this.noOfSlots);
            occupiedFloors.put(floorNumber,floor);
        }
        Floor floor = occupiedFloors.get(floorNumber);
        floor.setFloor(floorNumber,removedSlot);
    }

}
