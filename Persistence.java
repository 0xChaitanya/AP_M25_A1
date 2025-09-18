import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import AbstractClasses.*;
public class Persistence{
    public void safeToFile(FleetManager details, String filename) throws IOException{
        FileWriter vehicleDetails = new FileWriter(filename + ".csv");

        vehicleDetails.write("Category,ID,FuelLevel,Current Passengers,Current Cargo,Maintenance Needed,Has Sail");

        for (List<String> lst : details.getVehicleDetails()){
            vehicleDetails.write(String.format("%d,%d,%d,%d,%d,%d", lst.get(0), lst.get(1), lst.get(2), lst.get(3), lst.get(4), lst.get(5), lst.get(6)));
        }
    }

    public List<List<String>> loadFromFile(String filename) throws IOException{
        List<List<String>> data = new ArrayList<List<String>>();
        FileReader readData = new FileReader(filename + ".csv");
        Scanner read = new Scanner(readData);

        while (read.hasNextLine()){
            String
        }

        return data;
    }
}
