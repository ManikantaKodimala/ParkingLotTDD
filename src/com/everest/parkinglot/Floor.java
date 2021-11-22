package com.everest.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class Floor {
    private Map<Integer,Slot> floorMap;
    private int floorNumber;
    private int noOfSlots;

    public Floor(int floorNumber, int noOfSlots){
        this.floorNumber = floorNumber;
        this.noOfSlots=noOfSlots;
        this.floorMap=new HashMap<Integer,Slot>();
        createFloor();
    }

    private void createFloor() {
        for(int i=1;i<noOfSlots;i++) {
            this.floorMap.put(i, new Slot(i));
        }
    }

}
