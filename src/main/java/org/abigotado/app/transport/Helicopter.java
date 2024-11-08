package org.abigotado.app.transport;

import org.abigotado.app.enums.EngineType;
import org.abigotado.app.enums.FuelType;
import org.abigotado.app.interfaces.FuelPowered;

public final class Helicopter extends AirVehicle implements FuelPowered {
    private final FuelType fuelType;

    public Helicopter(String name, double speed) {
        super(name, speed, EngineType.TURBOPROP);
        this.fuelType = FuelType.KEROSENE;
    }

    @Override public FuelType getFuelType() {
        return fuelType;
    }

    @Override public void refuel() {
        System.out.println("Refueling the helicopter with kerosene.");
    }

    @Override public void move() {
        System.out.println("The helicopter is hovering in the air.");
    }

    @Override public void displayInfo() {
        System.out.printf("Helicopter: %s, Speed: %.2f km/h, Engine: %s, Fuel: %s%n",
                          name,
                          speed,
                          engineType,
                          fuelType
        );
    }
}
