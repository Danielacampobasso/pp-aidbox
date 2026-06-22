package com.estg.pickingManagement;

import com.estg.core.ItemType;

public class RefrigeratedVehicleImpl extends AbstractVehicle {

    private final double maxDistance;

    public RefrigeratedVehicleImpl(double maxCapacity, ItemType supplyType, double maxDistance) {
        super(maxCapacity, supplyType);   
        this.maxDistance = maxDistance;   
    }

    public double getMaxDistance() {
        return this.maxDistance;
    }
}