import java.io.FileWriter;
import java.io.IOException;
public class Persistence extends FleetManager{
    public void safeToFile(String filename) throws IOException{
        FileWriter vehicleDetails = new FileWriter(filename + ".csv");

        vehicleDetails.write("Category,ID,FuelLevel,Current Passengers,Current Cargo,Maintenance Needed,Has Sail");
    }
}
