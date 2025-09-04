public abstract class LandVehicle extends Vehicle {
    private int numWheels;

    public LandVehicle(String id, String model, double maxSpeed, double currentMileage, int numWheels){
        super(id, model, maxSpeed, currentMileage);
        this.numWheels = numWheels;
    }

    public double estimateJourneyTime(double distance){
        return (distance / this.getMaxSpeed()) * 1.1;
    }
}
