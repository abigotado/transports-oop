package org.abigotado.app.transport;

import org.abigotado.app.enums.EngineType;

public final class AirBalloon extends AirVehicle {
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
