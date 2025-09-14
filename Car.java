public class Car extends LandVehicle implements FuelConsumable, PassengerCarrier, Maintainable {
    private double fuelLevel = 0;
    private int passengerCapacity = 5;
    private int currentPassengers;
    private boolean maintenanceNeeded;

    public void move(double distance){
        System.out.println("Driving on road");
    }

    public double calculateFuelEfficiency(){
        return 15;
    }

    public double consumeFuel(double distance){

        if (fuelLevel < (1 / calculateFuelEfficiency()) * distance){
            System.out.println("throws InsufficientFuelException");
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

    public void boardPassengers(int count){

    }

    public void disembarkPassengers(){
        
    }
}
