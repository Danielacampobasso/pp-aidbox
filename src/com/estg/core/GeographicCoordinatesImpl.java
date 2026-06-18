package com.estg.core;

public class GeographicCoordinatesImpl implements GeographicCoordinates {

    private final double latitude;
    private final double longitude;

    public GeographicCoordinatesImpl(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public double getLatitude() {
        return this.latitude;
    }

    @Override
    public double getLongitude() {
        return this.longitude;
    }
}