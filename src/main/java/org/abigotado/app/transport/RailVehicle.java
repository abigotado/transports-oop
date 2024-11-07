package org.abigotado.app.transport;

import org.abigotado.app.enums.EngineType;
import org.abigotado.app.interfaces.ElectricPowered;

sealed abstract class RailVehicle extends Vehicle permits Metro {
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