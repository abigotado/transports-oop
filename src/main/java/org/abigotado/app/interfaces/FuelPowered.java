package org.abigotado.app.interfaces;

import org.abigotado.app.enums.FuelType;

interface FuelPowered {
    FuelType getFuelType();
    void refuel();
}
