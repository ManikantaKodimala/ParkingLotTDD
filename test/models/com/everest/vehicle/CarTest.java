package com.everest.vehicle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {
    @Test
    public void getVehicleType(){
        Vehicle vehicle= new Car("CAR","AP-12 TB 234","Blue");
        String expected = "CAR";
        String received=vehicle.getVehicleType();
        assertEquals(expected, received);
    }
}
