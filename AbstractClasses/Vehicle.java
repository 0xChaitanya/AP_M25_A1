package AbstractClasses;
import Exceptions.*;

public abstract class Vehicle implements Comparable<Vehicle>{
    private String id;
    private String model;
    private double maxSpeed;
    private double currentMileage;

    public Vehicle(String id, String model, double maxSpeed, double currentMileage){
        this.id = id;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.currentMileage = currentMileage;
    }

    public abstract void move(double distance) throws InvalidOperationException;
    public abstract double calculateFuelEfficiency();
    public abstract double estimateJourneyTime(double distance);

    public void displayInfo(){
        System.out.println(id);
        System.out.println(model);
        System.out.println(maxSpeed);
        System.out.println(currentMileage);
    }

    public double getCurrentMileage(){
        return this.currentMileage;
    }

    public String getId(){
        return this.id;
    }

    /**
     * getter method for maxSpeed
     * @return maxSpeed;
     */
    public double getMaxSpeed(){
        return this.maxSpeed;
    }

    public int compareTo(Vehicle V){
        return Double.compare(this.calculateFuelEfficiency(), V.calculateFuelEfficiency());
    }
}