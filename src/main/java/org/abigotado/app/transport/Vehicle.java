package org.abigotado.app.transport;

import org.abigotado.app.enums.EngineType;

public sealed abstract class Vehicle permits AirVehicle, LandVehicle, RailVehicle {
    protected String name;
    protected double speed;

    public Vehicle(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    public abstract void move();
    public abstract void displayInfo();
}

sealed abstract class LandVehicle extends Vehicle permits Car {
    protected EngineType engineType;

    public LandVehicle(String name, double speed, EngineType engineType) {
        super(name, speed);
        this.engineType = engineType;
    }
}

sealed abstract class RailVehicle extends Vehicle {
    protected EngineType engineType;

    public RailVehicle(String name, double speed, EngineType engineType) {
        super(name, speed);
        this.engineType = engineType;
    }
}

sealed abstract class AirVehicle extends Vehicle {
    protected EngineType engineType;

    public AirVehicle(String name, double speed, EngineType engineType) {
        super(name, speed);
        this.engineType = engineType;
    }
}
