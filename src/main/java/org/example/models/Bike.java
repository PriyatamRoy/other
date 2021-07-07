package org.example.models;

public class Bike implements Vehicle{
    private String registrationNumber;
    private String color;
    private VehicleType vehicleType = VehicleType.FOUR_WHEELER;

    public Bike(String registrationNumber, String color) {
        this.color = color;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String getColor() {
        return color;
    }
}
