package org.abigotado.app.transport;

import org.abigotado.app.enums.EngineType;
import org.abigotado.app.enums.FuelType;
import org.abigotado.app.interfaces.ElectricPowered;
import org.abigotado.app.interfaces.FuelPowered;

sealed abstract class RailVehicle extends Vehicle permits ExpressTrain, Metro, Tram {
    protected EngineType engineType;

    public RailVehicle(String name, double speed, EngineType engineType) {
        super(name, speed);
        this.engineType = engineType;
    }
}

final class Metro extends RailVehicle implements ElectricPowered {
    public Metro(String name, double speed) {
        super(name, speed, EngineType.ELECTRIC);
    }

    @Override public void charge() {
        System.out.println("Charging the metro train.");
    }

    @Override public void move() {
        System.out.println("The metro is moving underground.");
    }

    @Override public void displayInfo() {
        System.out.printf("Metro: %s, Speed: %.2f km/h, Engine: %s%n", name, speed, engineType);
    }
}

final class ExpressTrain extends RailVehicle implements FuelPowered {
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

final class Tram extends RailVehicle implements ElectricPowered {
    public Tram(String name, double speed) {
        super(name, speed, EngineType.ELECTRIC);
    }

    @Override public void move() {
        System.out.println("The tram " + name + " is moving on the rails.");
    }

    @Override public void displayInfo() {
        System.out.printf("Tram: %s, Speed: %.2f km/h, Engine: %s%n", name, speed, engineType);
    }

    @Override public void charge() {
        System.out.println("Charging the tram.");
    }
}

