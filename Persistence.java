import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import AbstractClasses.*;
public class Persistence{
    public void safeToFile(FleetManager details, String filename) throws IOException{
        FileWriter vehicleDetails = new FileWriter(filename + ".csv");

        vehicleDetails.write("Category,ID,FuelLevel,Current Passengers,Current Cargo,Maintenance Needed,Has Sail");

        for (List<String> lst : details.getVehicleDetails()){
            vehicleDetails.write(String.format("%d,%d,%d,%d,%d,%d", lst.get(0), lst.get(1), lst.get(2), lst.get(3), lst.get(4), lst.get(5), lst.get(6)));
        }
    }

    public void loadFromFile(String filename){};
}
