package org.abigotado.app.transport;

import org.abigotado.app.enums.EngineType;
import org.abigotado.app.interfaces.ElectricPowered;

public final class Tram extends RailVehicle implements ElectricPowered {
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
