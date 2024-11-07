package org.abigotado.app.transport;

import org.abigotado.app.enums.EngineType;
import org.abigotado.app.enums.FuelType;
import org.abigotado.app.interfaces.FuelPowered;

sealed abstract class AirVehicle extends Vehicle {
    protected EngineType engineType;

    public AirVehicle(String name, double speed, EngineType engineType) {
        super(name, speed);
        this.engineType = engineType;
    }
}

final class Airplane extends AirVehicle implements FuelPowered {
    private final FuelType fuelType;

    public Airplane(String name, double speed) {
        super(name, speed, EngineType.JET);
        this.fuelType = FuelType.KEROSENE;
    }

    @Override
    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the airplane with kerosene.");
    }

    @Override
    public void move() {
        System.out.println("The airplane is flying in the sky.");
    }

    @Override
    public void displayInfo() {
        System.out.printf("Transport: %s, Speed: %.2f km/h, Engine: %s, Fuel: %s%n",
                          name, speed, engineType, fuelType);
    }
}
