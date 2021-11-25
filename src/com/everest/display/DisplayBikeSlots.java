package com.everest.display;

import com.everest.parkinglot.Floor;
import com.everest.parkinglot.ParkingLot;
import com.everest.parkinglot.util.Parking;

import java.util.ArrayList;
import java.util.Map;

public class DisplayBikeSlots implements Display {
    int slotStartsAt= 2;
    int slotEndsAt=3;

    @Override
    public void displayHandler(String displayType, ParkingLot parkingLot) {
        switch (displayType) {
            case "free_count":
                displayFreeSlotsCount(parkingLot);
                break;
            case "free_slots":
                displayFreeSlots(parkingLot);
                break;
            case "occupied_slots":
                displayOccupiedSlots(parkingLot);
                break;
        }
    }

    @Override
    public void displayFreeSlots(ParkingLot parkingLot) {
        Map<Integer, Floor> freeFloors = parkingLot.getFreeFloors();
        Floor floor;
        ArrayList<Integer> freeSlotList = new ArrayList<>();
        for (int i = 1; i <= parkingLot.getNoOfFloors(); i++) {
            if (freeFloors.containsKey(i)) {
                floor = freeFloors.get(i);
                for (int j = slotStartsAt; j <=slotEndsAt; j++) {
                    if (!floor.getSlot(j).isVehicleParked()) {
                        freeSlotList.add(j);
                    }
                }
                System.out.println("Free slots for CAR on Floor" + i + " : " + freeSlotList.toString());
                freeSlotList.clear();
            }
        }

    }

    @Override
    public void displayFreeSlotsCount(ParkingLot parkingLot) {
        Map<Integer, Floor> freeFloors = parkingLot.getFreeFloors();
        int freeSlots = 0;
        Floor floor;
        for (int i = 1; i <= parkingLot.getNoOfFloors(); i++) {
            if (freeFloors.containsKey(i)) {
                floor = freeFloors.get(i);
                for (int j = slotStartsAt; j <=slotEndsAt; j++) {
                    if (!floor.getSlot(j).isVehicleParked()) {
                        freeSlots++;
                    }
                }
                System.out.println("No of slots free for CAR on Floor " + i + " : " + freeSlots);
            freeSlots=0;
            }
        }

    }

    @Override
    public void displayOccupiedSlots(ParkingLot parkingLot) {
        Map<Integer, Floor> occupiedFloors = parkingLot.getOccupiedFloors();
        Floor floor;
        ArrayList<Integer> freeSlotList = new ArrayList<>();
        for (int i = 1; i <= parkingLot.getNoOfFloors(); i++) {
            if (occupiedFloors.containsKey(i)) {
                floor = occupiedFloors.get(i);
                for (int j = slotStartsAt; j <=slotEndsAt; j++) {
                    if (floor.getSlot(j).isVehicleParked()) {
                        freeSlotList.add(j);
                    }
                }
                System.out.println("Occupied slots for CAR on Floor" + i + " : " + freeSlotList.toString());
                freeSlotList.clear();
            }
        }
    }
}
