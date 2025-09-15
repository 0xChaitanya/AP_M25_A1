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

//    public double getTotalFuelConsumption(double distance){
//        for (Vehicle V : fleet){
//            if (V)
//        }
//    }

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


}

