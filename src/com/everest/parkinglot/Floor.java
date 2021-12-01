package com.everest.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Floor {
    public Map<Integer, Slot> floorMap;
    private int floorNumber;
    private int noOfSlots;

    public Floor(int floorNumber, int noOfSlots) {
        this.floorNumber = floorNumber;
        this.noOfSlots = noOfSlots;
        this.floorMap = new HashMap<Integer, Slot>();
        createFloor();
    }

    private void createFloor() {
        for (int i = 1; i <=noOfSlots; i++) {
            this.floorMap.put(i, new Slot(i));
        }
    }

    public Slot getSlot(int slotNumber) {
        return this.floorMap.get(slotNumber);
    }

    public int getNoOfSlots() {
        return this.noOfSlots;
    }

    public Slot removeFreeSlot(int slotNumber) {
        Slot removedSlot = this.floorMap.remove(slotNumber);
        return removedSlot;
    }

    public int getSlotsCount(){
        return this.floorMap.size();
    }

    public Set<Integer> getAllSlotsId(){
        return this.floorMap.keySet();
    }

    public void setFloor(int floorNumber, Slot removedSlot) {
        this.floorMap.put(floorNumber,removedSlot);
    }

    public Set<Integer> getSlotkeys() {
        return this.floorMap.keySet();
    }
}
