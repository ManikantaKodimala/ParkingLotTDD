package com.everest.parkinglot;

import com.everest.vehicle.Car;
import com.everest.vehicle.Vehicle;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SlotTest extends TestCase {
    private static Slot slot=new Slot(1);
    private static Vehicle vehicle=new Car("CAR","Ap12T134","blue");
//    @BeforeClass
//    public void beforeAll(){
//        int slotId=1;
//        slot= new Slot(1);
//        vehicle= new Car("CAR","Ap12T134","blue");
//    }

    @Test
    public void testParkVehicle() {
        this.slot.parkVehicle(vehicle);
        boolean expected=true;
        boolean received = this.slot.isVehicleParked();
        assertEquals(expected,received);

    }

    @Test
    public void testUnParkVehicle() {
        this.slot.unParkVehicle();
        boolean expected=false;
        boolean received = this.slot.isVehicleParked();
        assertEquals(expected,received);
    }
}