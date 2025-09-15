package ConcreteClasses;

import AbstractClasses.*;
import Interfaces.*;
import Exceptions.*;

public class Airplane extends AirVehicle implements FuelConsumable, PassengerCarrier, CargoCarrier, Maintainable{
    private int fuelLevel = 0;
    private int passengerCapacity = 200;
    private int currentPassengers = 0;
    private double cargoCapacity = 10000;
    private double currentCargo = 0;
    private boolean maintenanceNeeded = false;

    public Airplane(String id, String model, double maxSpeed, double currentMileage, double maxAltitude){
        super(id, model, maxSpeed, currentMileage,  maxAltitude);
    }

    public void move(double distance) throws InvalidOperationException{
        if (distance < 0) {
            throw new InvalidOperationException("Distance cannot be less than zero.");
        }
        System.out.println("Flying at" + getMaxAltitude());
    }

    public double calculateFuelEfficiency(){
        return 5;
    }

    //FuelConsumable methods implementing
    public void refuel(double amount) throws InvalidOperationException{
        if (amount < 0){
            throw new InvalidOperationException("Fuel level cannot be less than zero");
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

    //PassengerCarrier methods implementing
    public void boardPassengers(int count) throws OverloadException{
        if (currentPassengers + count > passengerCapacity){
            throw new OverloadException("Airplane Overloaded with passengers.");
        }
        currentPassengers += count;
    }

    public void disembarkPassengers(int count) throws InvalidOperationException{
        if (currentPassengers < count){
            throw new InvalidOperationException("Either count of passengers to embark is less that zero or there isn't sufficient passengers to disembark.");
        }
        currentPassengers -= count;
    }

    public int getPassengerCapacity(){
        return passengerCapacity;
    }

    public int getCurrentPassengers(){
        return currentPassengers;
    }

    //CargoCarrier methods implmenting
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
