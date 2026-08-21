package com.estg.core;

import java.time.LocalDateTime;

import com.estg.core.exceptions.AidBoxException;
import com.estg.core.exceptions.ContainerException;
import com.estg.core.exceptions.MeasurementException;
import com.estg.pickingManagement.PickingMap;
import com.estg.pickingManagement.Vehicle;
import com.estg.core.exceptions.PickingMapException;   
import com.estg.core.exceptions.VehicleException;      
public class InstitutionImpl implements Institution {

    private final String name;
    private AidBox[] aidBoxes;
    private int numberOfAidBoxes;
    private Vehicle[] vehicles;
    private boolean[] vehiclesEnabled;
    private int numberOfVehicles;
    private PickingMap[] pickingMaps;
    private int numberOfPickingMaps;

    public InstitutionImpl(String name) {
        this.name = name;
        this.aidBoxes = new AidBox[10];
        this.numberOfAidBoxes = 0;
        this.vehicles = new Vehicle[10];
        this.vehiclesEnabled = new boolean[10];
        this.numberOfVehicles = 0;
        this.pickingMaps = new PickingMap[10];
        this.numberOfPickingMaps = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean addAidBox(AidBox aidBox) throws AidBoxException {
        if (aidBox == null) {
            throw new AidBoxException("A caixa não pode ser null");
        }
        if (this.numberOfAidBoxes == this.aidBoxes.length) {
            AidBox[] temp = new AidBox[this.aidBoxes.length * 2];
            for (int i = 0; i < this.numberOfAidBoxes; i++) {
                temp[i] = this.aidBoxes[i];
            }
            this.aidBoxes = temp;
        }
        this.aidBoxes[this.numberOfAidBoxes] = aidBox;
        this.numberOfAidBoxes++;
        return true;
    }

    @Override
    public AidBox[] getAidBoxes() {
        AidBox[] copy = new AidBox[this.numberOfAidBoxes];
        for (int i = 0; i < this.numberOfAidBoxes; i++) {
            copy[i] = this.aidBoxes[i];
        }
        return copy;
    }

    @Override
    public Container getContainer(AidBox aidBox, ItemType itemType) throws ContainerException {
        if (aidBox == null || itemType == null) {
            throw new ContainerException("Parâmetros inválidos");
        }
        return aidBox.getContainer(itemType);
    }

    @Override
    public double getDistance(AidBox aidBox) throws AidBoxException {
        if (aidBox == null) {
            throw new AidBoxException("A caixa não pode ser null");
        }
        // TODO: a distância da Base às caixas será ligada quando fizermos o Importer
        return -1;
    }

    @Override
    public boolean addMeasurement(Measurement measurement, Container container)
            throws ContainerException, MeasurementException {
        if (measurement == null) {
            throw new MeasurementException("A medição não pode ser null");
        }
        if (container == null) {
            throw new ContainerException("O contentor não pode ser null");
        }
        return container.addMeasurement(measurement);
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) throws VehicleException {
        if (vehicle == null) {
            throw new VehicleException("O veículo não pode ser null");
        }
        if (this.numberOfVehicles == this.vehicles.length) {
            Vehicle[] tempV = new Vehicle[this.vehicles.length * 2];
            boolean[] tempE = new boolean[this.vehicles.length * 2];
            for (int i = 0; i < this.numberOfVehicles; i++) {
                tempV[i] = this.vehicles[i];
                tempE[i] = this.vehiclesEnabled[i];
            }
            this.vehicles = tempV;
            this.vehiclesEnabled = tempE;
        }
        this.vehicles[this.numberOfVehicles] = vehicle;
        this.vehiclesEnabled[this.numberOfVehicles] = true;
        this.numberOfVehicles++;
        return true;
    }

    @Override
    public Vehicle[] getVehicles() {
        Vehicle[] copy = new Vehicle[this.numberOfVehicles];
        for (int i = 0; i < this.numberOfVehicles; i++) {
            copy[i] = this.vehicles[i];
        }
        return copy;
    }

    @Override
    public void enableVehicle(Vehicle vehicle) throws VehicleException {
        for (int i = 0; i < this.numberOfVehicles; i++) {
            if (this.vehicles[i].equals(vehicle)) {
                this.vehiclesEnabled[i] = true;
                return;
            }
        }
        throw new VehicleException("Veículo não encontrado");
    }

    @Override
    public void disableVehicle(Vehicle vehicle) throws VehicleException {
        for (int i = 0; i < this.numberOfVehicles; i++) {
            if (this.vehicles[i].equals(vehicle)) {
                this.vehiclesEnabled[i] = false;
                return;
            }
        }
        throw new VehicleException("Veículo não encontrado");
    }

    @Override
    public boolean addPickingMap(PickingMap pickingMap) throws PickingMapException {
        if (pickingMap == null) {
            throw new PickingMapException("O picking map não pode ser null");
        }
        if (this.numberOfPickingMaps == this.pickingMaps.length) {
            PickingMap[] temp = new PickingMap[this.pickingMaps.length * 2];
            for (int i = 0; i < this.numberOfPickingMaps; i++) {
                temp[i] = this.pickingMaps[i];
            }
            this.pickingMaps = temp;
        }
        this.pickingMaps[this.numberOfPickingMaps] = pickingMap;
        this.numberOfPickingMaps++;
        return true;
    }

    @Override
    public PickingMap[] getPickingMaps() {
        PickingMap[] copy = new PickingMap[this.numberOfPickingMaps];
        for (int i = 0; i < this.numberOfPickingMaps; i++) {
            copy[i] = this.pickingMaps[i];
        }
        return copy;
    }

    @Override
    public PickingMap[] getPickingMaps(LocalDateTime from, LocalDateTime to) {
        // TODO: filtrar por intervalo de datas quando PickingMap tiver getDate
        return new PickingMap[0];
    }

    @Override
    public PickingMap getCurrentPickingMap() throws PickingMapException {
        // TODO: devolver o mais recente quando PickingMap tiver getDate
        if (this.numberOfPickingMaps == 0) {
            return null;
        }
        return this.pickingMaps[this.numberOfPickingMaps - 1];
    }
}