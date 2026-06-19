package com.estg.core;     
import java.time.LocalDateTime;

public class MeasurementImpl implements Measurement {

    private final LocalDateTime date;
    private final double value;

     public MeasurementImpl(LocalDateTime date, double value) {
        this.date = date;
        this.value = value;
     }

      @Override
    public LocalDateTime getDate() {
        return this.date;
    }

    @Override
    public double getValue() {
        return this.value;
    }
}