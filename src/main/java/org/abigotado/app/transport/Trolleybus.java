package org.abigotado.app.transport;

import org.abigotado.app.enums.EngineType;
import org.abigotado.app.interfaces.ElectricPowered;

public final class Trolleybus extends LandVehicle implements ElectricPowered {
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
