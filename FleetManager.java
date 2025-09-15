import AbstractClasses.*;
import Exceptions.*;
import java.util.ArrayList;
import java.util.List;

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

    public double getTotalFuelConsumption(double distance){
        for (Vehicle V : fleet){
            if (V)
        }
    }

    public void maintainAll(){
        for (Vehicle V : fleet){
            if (V.needsMaintenance())
        }
    }
}

