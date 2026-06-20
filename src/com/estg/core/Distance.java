package com.estg.core;

public class Distance {

    private final AidBox destination;
    private final double distance;
    private final double duration;

    public Distance(AidBox destination, double distance, double duration) {
        this.destination = destination;
        this.distance = distance;
        this.duration = duration;
    }

    public AidBox getDestination() {
        return this.destination;
    }

    public double getDistance() {
        return this.distance;
    }

    public double getDuration() {
        return this.duration;
    }
}