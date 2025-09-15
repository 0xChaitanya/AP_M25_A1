import Exceptions.*;
import Interfaces.*;
import AbstractClasses.*;

import java.security.InvalidAlgorithmParameterException;

public class Car extends LandVehicle implements FuelConsumable, PassengerCarrier, Maintainable {
    private double fuelLevel = 0;
    private int passengerCapacity = 5;
    private int currentPassengers = 0;
    private boolean maintenanceNeeded;

    public Car(String id, String model, double maxSpeed, double currentMileage){
        super(id, model, maxSpeed, currentMileage, 4);
    }

    public void move(double distance) throws InvalidOperationException{
        if (distance < 0){
            throw new InvalidOperationException("distance can't be less than zero.");
        }
        System.out.println("Driving on road");
    }

    public double calculateFuelEfficiency(){
        return 15;
    }

    public double consumeFuel(double distance) throws InsufficientFuelException{

        if (fuelLevel < (1 / calculateFuelEfficiency()) * distance){
            throw new InsufficientFuelException("Insufficient Fuel");
        }
        
        return (1 / calculateFuelEfficiency()) * distance;
    }

    //FuelConsumable methods implementing
    public void refuel(double amount){
        fuelLevel += amount;
    }

    public double getFuelLevel(){
        return fuelLevel;
    }

    public void boardPassengers(int count) throws OverloadException {
        if (currentPassengers + count > 5){
            throw new OverloadException("car overloaded.");
        }
        currentPassengers += count;
    }

    public void disembarkPassengers(int count) throws InvalidOperationException{
        if (count > currentPassengers){
            throw new InvalidOperationException("Exception: number of passengers are less than specified.");
        }
        currentPassengers -= count;
    }

    public int getPassengerCapacity(){
        return passengerCapacity;
    }

    public int getCurrentPassengers(){
        return currentPassengers;
    }

    //Maintainable methods implementing
    public void scheduleMaintenance(){
        maintenanceNeeded = true;
    }

    public boolean needsMaintenance(){
        return getCurrentMileage() > 1000;
    }

    public void performMaintenance(){
        maintenanceNeeded = false;
        System.out.println("maintenance successful.");
    }
}
