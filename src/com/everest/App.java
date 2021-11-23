package com.everest;

import com.everest.parkinglot.ParkingLot;
import com.everest.vehicle.Car;
import com.everest.vehicle.Vehicle;

import java.util.Scanner;

public class App {
    public  enum InputCommands{
        create_parking_lot,display,park_vehicle,unpark_vehicle,free_count,free_slots,occupied_slots
    }

    public static ParkingLot parkingLot;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;
        String[] splitInput;
        System.out.println("Parking Lot");

        while(true){
            input=sc.nextLine();
            if(input.equals("exit")){
                break;
            }
            splitInput=input.split(" ",-1);
            handler(splitInput);
        }
    }
    public static void handler(String[] splitInput){
        String type;
        String registration;
        String colour;
        switch (InputCommands.valueOf(splitInput[0])) {
            case create_parking_lot -> {
                parkingLot = new ParkingLot(splitInput[1], Integer.parseInt(splitInput[2]), Integer.parseInt(splitInput[3]));
                System.out.println("Created parking lot with " + splitInput[2] + " floors and " + splitInput[3] + " slots per floor");
            }
            case park_vehicle -> {
                type = splitInput[1];
                registration = splitInput[2];
                colour = splitInput[3];
                Vehicle vehicle = new Car(type,registration, colour);
                System.out.println(parkingLot.parkVehicle(vehicle));

            }
//            case display -> {
//                Display display = new Display();
//                switch (InputCommands.valueOf(splitInput[1])) {
//                    case free_count:
//                        display.displayFreeCountOf(splitInput[2]);
//                        break;
//                    case free_slots:
//                        display.displayFreeSlotsOf(splitInput[2]);
//                        break;
//                    case occupied_slots:
//                        display.displayOccupiedSlotsOf(splitInput[2]);
//                        break;
//                }
//            }
            case unpark_vehicle -> parkingLot.unParkVehicle(splitInput[1]);
        }
    }

}
