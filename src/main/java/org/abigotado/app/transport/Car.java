package org.abigotado.app.transport;

import org.abigotado.app.enums.EngineType;
import org.abigotado.app.enums.FuelType;
import org.abigotado.app.interfaces.FuelPowered;

public final class Car extends LandVehicle implements FuelPowered {
    private FuelType fuelType;

    public Car(String name, double speed, FuelType fuelType) {
        super(name, speed, EngineType.INTERNAL_COMBUSTION);
        this.fuelType = fuelType;
    }

    @Override public FuelType getFuelType() {
        return fuelType;
    }

    @Override public void refuel() {
        System.out.println("Refueling the car with " + fuelType);
    }

    @Override public void move() {
        System.out.println("The car is moving on the road.");
    }

    @Override public void displayInfo() {
        System.out.printf("Vehicle: %s, Speed: %.2f km/h, Engine: %s, Fuel: %s%n", name, speed, engineType, fuelType);
    }
}
