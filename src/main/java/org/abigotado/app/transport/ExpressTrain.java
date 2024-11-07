package org.abigotado.app.transport;

import org.abigotado.app.enums.EngineType;
import org.abigotado.app.enums.FuelType;
import org.abigotado.app.interfaces.FuelPowered;

public final class ExpressTrain extends RailVehicle implements FuelPowered {
    public ExpressTrain(String name, double speed) {
        super(name, speed, EngineType.INTERNAL_COMBUSTION);
    }

    @Override public void move() {
        System.out.println("The express train " + name + " is moving on the rails.");
    }

    @Override public void displayInfo() {
        System.out.printf("ExpressTrain: %s, Speed: %.2f km/h, Engine: %s%n", name, speed, engineType);
    }

    @Override public FuelType getFuelType() {
        return FuelType.DIESEL;
    }

    @Override public void refuel() {
        System.out.println("Refueling the express train with " + FuelType.DIESEL);
    }
}
