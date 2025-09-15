package ConcreteClasses;

import Exceptions.*;
import Interfaces.*;
import AbstractClasses.*;

public class Truck extends LandVehicle implements FuelConsumable, CargoCarrier, Maintainable {
    private double fuelLevel = 0;
    private double cargoCapacity = 5000;
    private double  currentCargo = 0;
    private boolean maintenanceNeeded = false;

    public Truck(String id, String model, double maxSpeed, double currentMileage, double currentCargo){
        super(id, model, maxSpeed, currentMileage, 8);
        this.currentCargo = currentCargo;
    }

    public void move(double distance) throws InvalidOperationException{
        if (distance < 0){
            throw new InvalidOperationException("Distance cannot be less than zero.");
        }
        System.out.println("Hauling cargo...");
    }

    public double calculateFuelEfficiency(){
        return 8;
    }

    public void refuel(double amount) throws InvalidOperationException{
        if (amount < 0){
            throw new InvalidOperationException("Fuel amount cannot be less that zero.");
        }
        fuelLevel += amount;
    }

    public double getFuelLevel(){
        return fuelLevel;
    }

    public double consumeFuel(double distance) throws InsufficientFuelException{
        if (fuelLevel < (1 / calculateFuelEfficiency()) * distance){
            throw new InsufficientFuelException("Insufficient Fuel");
        }

        return (1 / calculateFuelEfficiency()) * distance;
    }

    //CargoCarrier methods implementing
    public void loadCargo(double weight) throws OverloadException{
        if (currentCargo + weight > cargoCapacity){
            throw new OverloadException("Truck Overloaded.");
        }
        currentCargo += weight;
    }

    public void unloadCargo(double weight) throws InvalidOperationException{
        if (weight < currentCargo){
            throw new InvalidOperationException("Invalid value for weight");
        }
        currentCargo -= weight;
    }

    public double getCargoCapacity(){
        return cargoCapacity;
    }

    public double getCurrentCargo(){
        return currentCargo;
    }

    //Maintainable methods implementing
    public void scheduleMaintenance(){
        maintenanceNeeded = true;
    }

    public boolean needsMaintenance(){
        if (getCurrentMileage() > 1000) return true;
        return false;
    }

    public void performMaintenance(){
        maintenanceNeeded = false;
    }
}
