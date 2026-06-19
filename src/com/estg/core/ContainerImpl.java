package com.estg.core;
import java.time.LocalDate;

public class ContainerImpl implements Container {

    private final String code;
    private final double capacity;
    private final ItemType type;
    private Measurement[] measurements;
    private int numberOfMeasurements;

    public ContainerImpl(String code, double capacity, ItemType type) {
        this.code = code;
        this.capacity = capacity;
        this.type = type;
        this.measurements = new Measurement[10];
        this.numberOfMeasurements = 0;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public double getCapacity() {
        return this.capacity;
    }

    @Override
    public ItemType getType() {
        return this.type;
    }

    @Override
    public boolean addMeasurement(Measurement measurement) {
        if (this.numberOfMeasurements == this.measurements.length) {
            Measurement[] temp = new Measurement [this.measurements.length * 2];
            for(int i = 0; i< this.numberOfMeasurements; i++) {
                temp[i] = this.measurements[i];
            }
            this.measurements = temp;
        }
        this.measurements[this.numberOfMeasurements] = measurement;
        this.numberOfMeasurements++;
        return true;
    }

    @Override
    public Measurement[] getMeasurements(){
        Measurement[] copy = new Measurement[this.numberOfMeasurements];
        for (int i = 0; i < this.numberOfMeasurements; i++) {
            copy[i] = this.measurements[i];
        }   
        return copy;
    }

    @Override
    public Measurement[] getMeasurements(LocalDate date) {
        int count = 0;
        for  (int i = 0; i < this.numberOfMeasurements; i++) {
            if(this.measurements[i].getDate().toLocalDate().equals(date)) {
                count ++;
            }
        }

        Measurement[] result = new Measurement[count];

        int pos=0;
        for(int i=0; i < this.numberOfMeasurements; i++){
            if(this.measurements[i].getDate().toLocalDate().equals(date)) {
                result[pos] = this.measurements[i];
                pos++;
            }
        }
        return result;
    }
}