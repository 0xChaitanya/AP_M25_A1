package Interfaces;
import Exceptions.*;

public interface FuelConsumable{
    public void refuel(double amount) throws InvalidOperationException;
    public double getFuelLevel();
    public double consumeFuel(double distance) throws InsufficientFuelException;
}