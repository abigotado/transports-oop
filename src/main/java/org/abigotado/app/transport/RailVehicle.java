package org.abigotado.app.transport;

import org.abigotado.app.enums.EngineType;

sealed abstract class RailVehicle extends Vehicle {
    protected EngineType engineType;

    public RailVehicle(String name, double speed, EngineType engineType) {
        super(name, speed);
        this.engineType = engineType;
    }
}
