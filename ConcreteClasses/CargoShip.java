package ConcreteClasses;

import AbstractClasses.*;
import Exceptions.*;
import Interfaces.*;

public class CargoShip extends WaterVehicle implements FuelConsumable, CargoCarrier, Maintainable{
    private double fuelLevel = 0;
    private double cargoCapacity = 50000;
    private double currentCargo = 0;
    private boolean maintenanceNeeded = false;

    public CargoShip(String id, String model, double maxSpeed, double currentMileage, boolean hasSail){
        super(id, model, maxSpeed, currentMileage, hasSail);
    }

    public double calculateFuelEfficiency(){
        if (getFueled()){
            return 4;
        }
        return 0;
    }

    public void move(double distance) throws InvalidOperationException{
        if (distance < 0){
            throw new InvalidOperationException("Distance cannot be less than zero.");
        }
        System.out.println("Sailing with Cargo...");
    }

    //FuelConsumable methods implementing
    public void refuel(double amount) throws InvalidOperationException{
        if (amount < 0){
            throw new InvalidOperationException("Fuel amount cannot be negative");
        }
        if (getFueled()){
            fuelLevel += amount;
        }
    }

    public double getFuelLevel(){
        return fuelLevel;
    }

    public double consumeFuel(double amount) throws InsufficientFuelException{
        if (fuelLevel < (1 / calculateFuelEfficiency()) * distance){
            throw new InsufficientFuelException("Insufficient Fuel");
        }

        return (1 / calculateFuelEfficiency()) * distance;
    }

    //CargoCarrier methods implementing
    public void loadCargo(double weight) throws OverloadException{
        if (currentCargo + weight > cargoCapacity){
            throw new OverloadException("Aiplane Overloaded with cargo.");
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
    // will complete this class as per requirements later
}
