package com.estg.pickingManagement;

import com.estg.core.ItemType;

public abstract class AbstractVehicle implements Vehicle {

    private final double maxCapacity;
    private final ItemType supplyType;

    public AbstractVehicle(double maxCapacity, ItemType supplyType) {
        this.maxCapacity = maxCapacity;
        this.supplyType = supplyType;
    }

    @Override
    public double getMaxCapacity() {
        return this.maxCapacity;
    }

    @Override
    public ItemType getSupplyType() {
        return this.supplyType;
    }
}