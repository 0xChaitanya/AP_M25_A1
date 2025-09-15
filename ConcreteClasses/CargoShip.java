package ConcreteClasses;

import AbstractClasses.*;
import Exceptions.*;
import Interfaces.*;

public class CargoShip extends WaterVehicle implements FuelConsumable, CargoCarrier, Maintainable{
    private double fuelLevel = 0;
    private double cargoCapacity = 50000;
    private double currentCargo = 0;
    private double maintenanceNeeded = false;

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

    // will complete this class as per requirements later

}
