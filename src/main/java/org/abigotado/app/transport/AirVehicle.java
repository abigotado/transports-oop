package org.abigotado.app.transport;

import org.abigotado.app.enums.EngineType;
import org.abigotado.app.enums.FuelType;
import org.abigotado.app.interfaces.FuelPowered;

sealed abstract class AirVehicle extends Vehicle permits Airplane, Helicopter, AirBalloon {
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

    @Override public FuelType getFuelType() {
        return fuelType;
    }

    @Override public void refuel() {
        System.out.println("Refueling the airplane with kerosene.");
    }

    @Override public void move() {
        System.out.println("The airplane is flying in the sky.");
    }

    @Override public void displayInfo() {
        System.out.printf("Airplane: %s, Speed: %.2f km/h, Engine: %s, Fuel: %s%n", name, speed, engineType, fuelType);
    }
}

final class Helicopter extends AirVehicle implements FuelPowered {
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

final class AirBalloon extends AirVehicle {
    public AirBalloon(String name, double speed) {
        super(name, speed, EngineType.NONE);
    }

    @Override public void move() {
        System.out.println("The hot air balloon drifts through the sky with the wind.");
    }

    @Override public void displayInfo() {
        System.out.printf("AirBalloon: %s, Speed: %.2f km/h, Engine: %s%n", name, speed, engineType);
    }
}
