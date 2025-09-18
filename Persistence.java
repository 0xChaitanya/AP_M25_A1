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

        vehicleDetails.write("Category,ID,Model,Max Speed,FuelLevel,Current Passengers,Current Cargo,Current Mileage,Maintenance Needed,Has Sail");

        for (List<String> lst : details.getVehicleDetails()){
            vehicleDetails.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", lst.get(0), lst.get(1), lst.get(2), lst.get(3), lst.get(4), lst.get(5), lst.get(6), lst.get(7), lst.get(8), lst.get(9)));
        }
    }

    public List<List<String>> loadFromFile(String filename) throws IOException{
        List<List<String>> loadData = new ArrayList<List<String>>();
        List<String> lst;

        FileReader readData = new FileReader(filename + ".csv");
        Scanner read = new Scanner(readData);

        while (read.hasNextLine()){
            String data = read.nextLine();
            lst = new ArrayList<String>();

            for (String s : data.split(",")){
                lst.add(s);
            }

            loadData.add(lst);
        }

        read.close();
        return loadData;
    }
}
