import Interfaces.*;
import AbstractClasses.*;

public class Truck extends LandVehicle implements FuelConsumable, CargoCarrier, Maintainable {
    private double fuelLevel;
    private double cargoCapacity = 5000;
    private double currentCargo;
    private boolean maintenanceNeeded;

    public void move(){
        System.out.println("Hauling cargo...");
    }

    public double calculateFuelEfficiency(){
        return 8;
    }
}
