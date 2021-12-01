package com.everest.vehicle;

public class Bike implements Vehicle {
    private String type;
    private String registrationNumber;
    private String colour;

    public Bike(String type, String registrationNumber, String colour) {
        this.colour = colour;
        this.registrationNumber = registrationNumber;
        this.type = type;
    }

    @Override
    public String getVehicleType() {
        return this.type;
    }

    @Override
    public String getVehicleColour() {
        return this.colour;
    }

    @Override
    public String getVehicleRegistrationNumber() {
        return this.registrationNumber;
    }
}
