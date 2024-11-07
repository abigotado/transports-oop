package org.abigotado.app.transport;

import org.abigotado.app.enums.EngineType;
import org.abigotado.app.enums.FuelType;
import org.abigotado.app.interfaces.ElectricPowered;
import org.abigotado.app.interfaces.FuelPowered;

sealed abstract class LandVehicle extends Vehicle permits Bus, Car, Trolleybus {
    protected EngineType engineType;

    public LandVehicle(String name, double speed, EngineType engineType) {
        super(name, speed);
        this.engineType = engineType;
    }
}

final class Car extends LandVehicle implements FuelPowered {
    private final FuelType fuelType;

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
        System.out.printf("Car: %s, Speed: %.2f km/h, Engine: %s, Fuel: %s%n", name, speed, engineType, fuelType);
    }
}

final class Bus extends LandVehicle implements FuelPowered {
    private final FuelType fuelType;

    public Bus(String name, double speed, FuelType fuelType) {
        super(name, speed, EngineType.INTERNAL_COMBUSTION);
        this.fuelType = fuelType;
    }

    @Override public FuelType getFuelType() {
        return fuelType;
    }

    @Override public void refuel() {
        System.out.println("Refueling the bus with " + fuelType);
    }

    @Override public void move() {
        System.out.println("The bus is moving on the road.");
    }

    @Override public void displayInfo() {
        System.out.printf("Bus: %s, Speed: %.2f km/h, Engine: %s, Fuel: %s%n", name, speed, engineType, fuelType);
    }
}

final class Trolleybus extends LandVehicle implements ElectricPowered {
    public Trolleybus(String name, double speed) {
        super(name, speed, EngineType.ELECTRIC);
    }

    @Override public void charge() {
        System.out.println("Charging the trolleybus battery.");
    }

    @Override public void move() {
        System.out.println("The trolleybus is moving on the road using overhead lines.");
    }

    @Override public void displayInfo() {
        System.out.printf("Trolleybus: %s, Speed: %.2f km/h, Engine: %s", name, speed, engineType);
    }
}