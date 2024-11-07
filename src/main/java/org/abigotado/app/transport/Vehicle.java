package org.abigotado.app.transport;

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

