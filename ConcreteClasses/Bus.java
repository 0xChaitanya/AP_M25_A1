package ConcreteClasses;

import Exceptions.*;
import Interfaces.*;
import AbstractClasses.*;

public class Bus extends LandVehicle implements FuelConsumable, PassengerCarrier, CargoCarrier, Maintainable{
    private double fuelLevel = 0;
    private int passengerCapacity = 50;
    private int currentPassengers = 0;
    private double cargoCapacity = 500;
    private double currentCargo = 0;
    private boolean maintenanceNeeded = false;

    public Bus(String id, String model, double maxSpeed, double currentMileage, int currentPassengers ,double currentCargo){
        super(id, model, maxSpeed, currentMileage, 4);
        this.currentPassengers = currentPassengers;
        this.currentCargo = currentCargo;
    }

    public void move(double distance) throws InvalidOperationException{
        if (distance < 0){
            throw new InvalidOperationException("Distance cannot be less that zero.");
        }
        System.out.println("Transporting passengers and cargo...");
    }

    public double calculateFuelEfficiency(){
        return 10;
    }

    //FuelConsumable method implementing
    public void refuel(double amount) throws InvalidOperationException{
        if (amount < 0){
            throw new InvalidOperationException("Amount of fuel cannot be less than zero.");
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
            throw new OverloadException("Bus Overloaded with people.");
        }
        currentPassengers += count;
    }

    public void disembarkPassengers(int count) throws InvalidOperationException{
        if (currentPassengers < count){
            throw new InvalidOperationException("Count is either less that zero or less that currentPassengers");
        }
        currentPassengers -= count;
    }

    public int getPassengerCapacity(){
        return passengerCapacity;
    }

    public int getCurrentPassengers(){
        return currentPassengers;
    }

    //CargoCarrier methods implementing
    public void loadCargo(double weight) throws OverloadException{
        if (currentCargo + weight > cargoCapacity){
            throw new OverloadException("Bus Overloaded with cargo");
        }
        currentCargo += weight;
    }

    public void unloadCargo(double weight) throws InvalidOperationException{
        if (currentCargo < weight){
            throw new InvalidOperationException("Invalid value for weight. Either weight is less that zero or weight is less that the current cargo.");
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
