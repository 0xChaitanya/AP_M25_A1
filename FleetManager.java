import AbstractClasses.*;
import Exceptions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Class;

import ConcreteClasses.*;

public class FleetManager {
    private List<Vehicle> fleet = new ArrayList<Vehicle>();

    public void addVehicle(Vehicle v) throws InvalidOperationException{
        for (Vehicle V : fleet){
            if (V.getId().equals(v.getId())){
                throw new InvalidOperationException("Duplicate IDs");
            }
            fleet.add(v);
        }
    }

    public void removeVehicle(String id) throws InvalidOperationException{
        for (Vehicle V : fleet){
            if (V.getId().equals(id)){
                fleet.remove(V);
                break;
            }
        }
        throw new InvalidOperationException("ID not found.");
    }

    public void startAllJourney(double distance) throws InvalidOperationException{
        for (Vehicle V : fleet){
            V.move(distance);
        }
    }

    public double getTotalFuelConsumption(double distance) throws InsufficientFuelException{
        double result = 0;
        for (Vehicle V : fleet){
            if (V instanceof Car){
                Car car = (Car) V;
                result += car.consumeFuel(distance);
            }
            else if (V instanceof Bus){
                Bus bus = (Bus) V;
                result += bus.consumeFuel(distance);
            }
            else if (V instanceof Airplane){
                Airplane airplane = (Airplane) V;
                result += airplane.consumeFuel(distance);
            }
            else if (V instanceof CargoShip){
                CargoShip cargoship = (CargoShip) V;
                if (cargoship.getFueled() == true){
                    result += cargoship.consumeFuel(distance);
                }
            }
            else{
                Truck truck = (Truck) V;
                result += truck.consumeFuel(distance);
            }
        }

        return result;
    }

    public void maintainAll(){
        for (Vehicle V : fleet){
            if (V instanceof Car){
                Car car = (Car) V;
                if ((car.needsMaintenance())){
                    car.performMaintenance();
                }
            }
            else if (V instanceof Bus){
                Bus bus = (Bus) V;
                if (bus.needsMaintenance()){
                    bus.performMaintenance();
                }
            }
            else if (V instanceof Airplane){
                Airplane airplane = (Airplane) V;
                if (airplane.needsMaintenance()){
                    airplane.performMaintenance();
                }
            }
            else if (V instanceof CargoShip){
                CargoShip cargoship = (CargoShip) V;
                if (cargoship.needsMaintenance()){
                    cargoship.performMaintenance();
                }
            }
            else{
                Truck truck = (Truck) V;
                if (truck.needsMaintenance()){
                    truck.performMaintenance();
                }
            }
        }
    }

    public List<Vehicle> searchByType(Class<?> type){
        List<Vehicle> result = new ArrayList<Vehicle>();

        for (Vehicle V : fleet){
            if (type.isInstance(V)){
                result.add(V);
            }
        }

        return result;
    }

    public void sortFleetByEfficiency(){
        Collections.sort(fleet);
    }

    public double averageEfficiency(){
        double result = 0;
        double divisor = 0;

        for (Vehicle V : fleet){
            if (V instanceof Car){
                Car car = (Car) V;
                result += car.calculateFuelEfficiency();
                divisor++;
            }
            else if (V instanceof Bus){
                Bus bus = (Bus) V;
                result += bus.calculateFuelEfficiency();
                divisor++;
            }
            else if (V instanceof Airplane){
                Airplane airplane = (Airplane) V;
                result += airplane.calculateFuelEfficiency();
                divisor++;
            }
            else if (V instanceof CargoShip){
                CargoShip cargoship = (CargoShip) V;
                result += cargoship.calculateFuelEfficiency();
                divisor++;
            }
            else{
                Truck truck = (Truck) V;
                result += truck.calculateFuelEfficiency();
                divisor++;
            }
        }

        return result / divisor;
    }

    public double totalMileage(){
        double result = 0;
        for (Vehicle V : fleet){
            result += V.getCurrentMileage();
        }
        return result;
    }

    public String generateReport(){
        int carCount = 0;
        int busCount = 0;
        int cargoshipCount = 0;
        int truckCount = 0;
        int airplaneCount = 0;

        System.out.println();

        for (Vehicle V : fleet){
            if (V instanceof Car){
                carCount++;
            }
            else if (V instanceof Bus){
                busCount++;
            }
            else if (V instanceof Airplane){
                airplaneCount++;
            }
            else if (V instanceof CargoShip){
                cargoshipCount++;
            }
            else{
                truckCount++;
            }
        }

        String result = String.format(
                "Report:\n Total number of vehicles : %d\n\n Count by type:\n Airplane: %d\n Car: %d\n Bus: %d\n CargoShip: %d\n Truck: %d\n\n Average Fuel Efficiency: %f\n Total Mileage: %f\n \\",fleet.size(), airplaneCount, carCount, busCount, cargoshipCount, truckCount, averageEfficiency(), totalMileage());

        return result;
    }

    public List<Vehicle> getVehiclesNeedingMaintenance(){
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle V : fleet){
            if (V instanceof Car){
                Car car = (Car) V;
                if (car.needsMaintenance()){
                    result.add(car);
                }
            }
            else if (V instanceof Bus){
                Bus bus = (Bus) V;
                if (bus.needsMaintenance()){
                    result.add(bus);
                }
            }
            else if (V instanceof Airplane){
                Airplane airplane = (Airplane) V;
                if (airplane.needsMaintenance()){
                    result.add(airplane);
                }
            }
            else if (V instanceof CargoShip){
                CargoShip cargoship = (CargoShip) V;
                if (cargoship.needsMaintenance()){
                    result.add(cargoship);
                }
            }
            else{
                Truck truck = (Truck) V;
                if (truck.needsMaintenance()){
                    result.add(truck);
                }
            }
        }

        return result;
    }

    public List<List<String>> getVehicleDetails(){ //I have added this method because I want details of all vehicles to store in the CSV file
        List<List<String>> result = new ArrayList<List<String>>();

        List<String> carD;
        List<String> busD;
        List<String> airplaneD;
        List<String> cargoshipD;
        List<String> truckD;

        for (Vehicle V : fleet){
            carD = new ArrayList<String>();
            busD = new ArrayList<String>();
            airplaneD = new ArrayList<String>();
            cargoshipD = new ArrayList<String>();
            truckD = new ArrayList<String>();

            if (V instanceof Car){
                Car car = (Car) V;
                carD.add("Car");
                carD.add(car.getId());
                carD.add(car.getModel());
                carD.add(String.format("%f", car.getMaxSpeed()));
                carD.add(String.format("%f", car.getFuelLevel()));
                carD.add(String.format("%d", car.getCurrentPassengers()));
                carD.add("NA");
                carD.add(String.format("%f", car.getCurrentMileage()));
                carD.add(car.needsMaintenance() ? "Yes" : "No");
                carD.add("NA");
                carD.add("NA");
            }
            else if (V instanceof Bus){
                Bus bus = (Bus) V;
                busD.add("Bus");
                busD.add(bus.getId());
                busD.add(bus.getModel());
                busD.add(String.format("%f", bus.getMaxSpeed()));
                busD.add(String.format("%f", bus.getFuelLevel()));
                busD.add(String.format("%d", bus.getCurrentPassengers()));
                busD.add(String.format("%f", bus.getCurrentCargo()));
                busD.add(String.format("%f", bus.getCurrentMileage()));
                busD.add(bus.needsMaintenance() ? "Yes" : "No");
                busD.add("NA");
                busD.add("NA");
            }
            else if (V instanceof Airplane){
                Airplane airplane = (Airplane) V;
                airplaneD.add("Airplane");
                airplaneD.add(airplane.getId());
                airplaneD.add(airplane.getModel());
                airplaneD.add(String.format("%f", airplane.getMaxSpeed()));
                airplaneD.add(String.format("%d", airplane.getCurrentPassengers()));
                airplaneD.add(String.format("%f", airplane.getCurrentCargo()));
                airplaneD.add(String.format("%f", airplane.getCurrentMileage()));
                airplaneD.add(airplane.needsMaintenance() ? "Yes" : "No");
                airplaneD.add("NA");
                airplaneD.add(String.format("%f", airplane.getMaxAltitude()));

            }
            else if (V instanceof CargoShip){
                CargoShip cargoship = (CargoShip) V;
                cargoshipD.add("Cargo Ship");
                cargoshipD.add(cargoship.getId());
                cargoshipD.add(cargoship.getModel());
                cargoshipD.add(String.format("%f", cargoship.getMaxSpeed()));
                cargoshipD.add("NA");
                cargoshipD.add(String.format("%f", cargoship.getCurrentCargo()));
                cargoshipD.add(String.format("%f", cargoship.getCurrentMileage()));
                cargoshipD.add(cargoship.needsMaintenance() ? "Yes" : "No");
                cargoshipD.add(cargoship.getFueled() ? "Yes" : "No");
                cargoshipD.add("NA");
            }
            else{
                Truck truck = (Truck) V;
                truckD.add("Truck");
                truckD.add(truck.getId());
                truckD.add(truck.getModel());
                truckD.add(String.format("%f", truck.getMaxSpeed()));
                truckD.add("NA");
                truckD.add(String.format("%f", truck.getCurrentCargo()));
                truckD.add(String.format("%f", truck.getCurrentMileage()));
                truckD.add(truck.needsMaintenance() ? "Yes" : "No");
                truckD.add("NA");
                truckD.add("NA");
            }

            result.add(carD);
            result.add(busD);
            result.add(airplaneD);
            result.add(cargoshipD);
            result.add(truckD);
        }
        return result;
    }

    /***
     * refeulAll method is added to access it from class Main and refule all vehicles. Practically, it doesn't make sense to refuel all vehicles at once because each have different fuel capacity.
     */
    public void refuelAll(double amount) throws InvalidOperationException{
        for (Vehicle V : fleet){
            if (V instanceof Car){
                Car car = (Car) V;
                car.refuel(amount);
            }
            else if (V instanceof Bus){
                Bus bus = (Bus) V;
                bus.refuel(amount);
            }
            else if (V instanceof Airplane){
                Airplane airplane = (Airplane) V;
                airplane.refuel(amount);
            }
            else if (V instanceof CargoShip){
                CargoShip cargoship = (CargoShip) V;
                cargoship.refuel(amount);
            }
            else{
                Truck truck = (Truck) V;
                truck.refuel(amount);
            }
        }
    }
}

