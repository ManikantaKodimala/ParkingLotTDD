package com.everest.parkinglot;

import com.everest.parkingstrategy.ParkBikeStrategy;
import com.everest.parkingstrategy.ParkCarStrategy;
import com.everest.parkingstrategy.ParkStrategy;
import com.everest.parkingstrategy.ParkTruckStrategy;
import com.everest.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static int noOfSlots;
    private String parkingLotId;
    private static int noOfFloors;
    private Map<String, Map<Integer, Floor>> floorMap;

    public ParkingLot(String parkingLotId, int noOfFloors, int noOfSlots) {
        this.parkingLotId = parkingLotId;
        this.noOfFloors = noOfFloors;
        this.noOfSlots = noOfSlots;
        floorMap = new HashMap<String, Map<Integer, Floor>>();
        this.createParkingLot();
    }

    private void createParkingLot() {
        Map<Integer, Floor> floor = new HashMap<>();
        for (int i = 1; i <= this.noOfFloors; i++) {
            floor.put(i, new Floor(i, this.noOfSlots));
        }
        floorMap.put("Free_Floors",floor);
        floorMap.put("Occupied_Floors",new HashMap<>());
        dis(floorMap);
    }

    private void dis(Map<String, Map<Integer, Floor>> floorMap) {
        for (String  type : floorMap.keySet()) {
            System.out.println(type.toString());
            Map<Integer, Floor> hashh=floorMap.get(type);
            for (int floorNumber:
                 hashh.keySet()) {
                System.out.println("floor number"+floorNumber);
                Floor floor = hashh.get(floorNumber);
                System.out.println(" number of slots"+floor.getNoOfSlots());
                for (int i = 1; i <=floor.getNoOfSlots(); i++) {
                    System.out.println(floor.getSlot(i).getID());
                }
            }
        }
    }

    public String parkVehicle(Vehicle vehicle) {
        ParkStrategy strategy = this.getStrategy(vehicle.getVehicleType());
        String v = strategy.parkVehicle(vehicle, this);
        return v;
    }

    public Vehicle unParkVehicle(String ticketId) {
        ParkStrategy strategy = this.getStrategy(ticketId);
        return strategy.unParkVehicle(ticketId, this);
    }

    private ParkStrategy getStrategy(String vehicleType) {
        switch (vehicleType) {
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

    public Map<Integer, Floor> getOccupiedFloors() {
        return this.floorMap.get("Occupied_Floors");
    }

    public Map<Integer, Floor> getFreeFloors() {
        return this.floorMap.get("Free_Floors");
    }

    public int getNoOfFloors() {
        return this.noOfFloors;
    }

    public int getNoOfSlots() {
        return this.noOfSlots;
    }
}
