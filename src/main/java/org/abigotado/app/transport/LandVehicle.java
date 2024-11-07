package org.abigotado.app.transport;

import org.abigotado.app.enums.EngineType;

sealed abstract class LandVehicle extends Vehicle permits Bus, Car, Trolleybus {
    protected EngineType engineType;

    public LandVehicle(String name, double speed, EngineType engineType) {
        super(name, speed);
        this.engineType = engineType;
    }
}

