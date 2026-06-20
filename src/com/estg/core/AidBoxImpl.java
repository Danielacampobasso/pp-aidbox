package com.estg.core;

public class AidBoxImpl implements AidBox {

    private final String code;
    private final String zone;
    private final String refLocal;
    private final GeographicCoordinates coordinates;
    private Container[] containers;
    private int numberOfContainers;
    private Distance[] distances;
    private int numberOfDistances;

    public AidBoxImpl(String code, String zone, String refLocal, GeographicCoordinates coordinates) {
        this.code = code;
        this.zone = zone;
        this.refLocal = refLocal;
        this.coordinates = coordinates;
        this.containers = new Container[4];
        this.numberOfContainers = 0;
        this.distances = new Distance[10];
        this.numberOfDistances = 0;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getZone() {
        return this.zone;
    }

    @Override
    public String getRefLocal() {
        return this.refLocal;
    }

    @Override
    public GeographicCoordinates getCoordinates() {
        return this.coordinates;
    }

    @Override
    public boolean addContainer(Container container) {
        if (this.numberOfContainers == this.containers.length) {
            Container[] temp = new Container[this.containers.length * 2];
            for (int i = 0; i < this.numberOfContainers; i++) {
                temp[i] = this.containers[i];
            }
            this.containers = temp;
        }
        this.containers[this.numberOfContainers] = container;
        this.numberOfContainers++;
        return true;
    }

    @Override
    public Container[] getContainers() {
        Container[] copy = new Container[this.numberOfContainers];
        for (int i = 0; i < this.numberOfContainers; i++) {
            copy[i] = this.containers[i];
        }
        return copy;
    }

    @Override
    public Container getContainer(ItemType itemType) {
        for (int i = 0; i < this.numberOfContainers; i++) {
            if (this.containers[i].getType() == itemType) {
                return this.containers[i];
            }
        }
        return null;
    }

    public boolean addDistance(Distance distance) {
        if (this.numberOfDistances == this.distances.length) {
            Distance[] temp = new Distance[this.distances.length * 2];
            for (int i = 0; i < this.numberOfDistances; i++) {
                temp[i] = this.distances[i];
            }
            this.distances = temp;
        }
        this.distances[this.numberOfDistances] = distance;
        this.numberOfDistances++;
        return true;
    }

    @Override
    public double getDistance(AidBox aidBox) {
        for (int i = 0; i < this.numberOfDistances; i++) {
            if (this.distances[i].getDestination().equals(aidBox)) {
                return this.distances[i].getDistance();
            }
        }
        return -1;
    }

    @Override
    public double getDuration(AidBox aidBox) {
        for (int i = 0; i < this.numberOfDistances; i++) {
            if (this.distances[i].getDestination().equals(aidBox)) {
                return this.distances[i].getDuration();
            }
        }
        return -1;
    }
}