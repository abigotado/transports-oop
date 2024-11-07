package org.abigotado.app.interfaces;

import org.abigotado.app.enums.FuelType;

public interface FuelPowered {
    FuelType getFuelType();
    void refuel();
}
