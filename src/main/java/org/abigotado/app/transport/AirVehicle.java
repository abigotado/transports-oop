package org.abigotado.app.transport;

import org.abigotado.app.enums.EngineType;

sealed abstract class AirVehicle extends Vehicle permits Airplane, Helicopter, AirBalloon {
    protected EngineType engineType;

    public AirVehicle(String name, double speed, EngineType engineType) {
        super(name, speed);
        this.engineType = engineType;
    }
}

