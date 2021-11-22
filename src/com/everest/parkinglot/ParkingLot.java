package com.everest.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private  int noOfSlots;
    private  int noOfFloors;
    private Map<String, ArrayList<Floor>> floorMap;

    public ParkingLot(int noOfFloors,int noOfSlots){
        this.noOfFloors= noOfFloors;
        this.noOfSlots=noOfSlots;
        floorMap= new HashMap<String,ArrayList<Floor>>();
        createParkingLot();
    }

    private void createParkingLot() {
        ArrayList<Floor> floors= new ArrayList<>();
        for(int i=0;i<this.noOfFloors;i++){
            floors.add(new Floor(i+1,this.noOfSlots));
        }
        floorMap.put("Free_Floors",floors);
        floorMap.put("Occupied_Floors",new ArrayList<Floor>());
    }

}
