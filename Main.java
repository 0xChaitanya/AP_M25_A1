import java.util.Scanner;
import ConcreteClasses.*;
import Exceptions.*;
import Interfaces.*;
import AbstractClasses.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidOperationException, IOException, NullPointerException {

        System.out.println(
                "Menu:\n " +
                "1. Add Vehicle\n" +
                "2. Remove Vehicle\n" +
                "3. Start Journey\n" +
                "4. Refuel All\n" +
                "5. Perform Maintenance\n" +
                "6. Generate Report\n" +
                "7. Save Fleet\n" +
                "8. Load Fleet\n" +
                "9. Search by Type\n" +
                "10. List Vehicles Needing Maintenance\n" +
                "11. Exit"
        );

        Scanner input = new Scanner(System.in);
        FleetManager vehicles = new FleetManager();
        Persistence fileHandler = new Persistence();


        //Variables in USE
        int choice = input.nextInt();
        String id;
        String model;
        double maxSpeed;
        double currentMileage;
        double maxAltitude;
        int currentPassenger;
        double currentCargo;
        String sailed;
        boolean hasSailed;
        String vID;
        double distance;
        double amount;
        Vehicle type;

        Airplane airplane;
        Bus bus;
        Car car;
        CargoShip cargoShip;
        Truck truck;


        switch (choice){
            case 1:
                System.out.println(
                        "Choose Category\n" +
                                "1. Airplane\n" +
                                "2. Bus\n" +
                                "3. Car\n" +
                                "4. Cargo Ship\n" +
                                "5. Truck\n"
                );

                int choiceVehicle = input.nextInt();
                if (choiceVehicle == 1){
                    System.out.println("Enter ID : ");
                    id = input.next();
                    System.out.println("Enter Model : ");
                    model = input.next();
                    System.out.println("Enter Maximum Speed : ");
                    maxSpeed = input.nextDouble();
                    System.out.println("Enter Current Mileage");
                    currentMileage = input.nextDouble();
                    System.out.println("Enter Maximum Altitude : ");
                    maxAltitude = input.nextDouble();

                    airplane = new Airplane(id, model, maxSpeed, currentMileage, maxAltitude);
                    vehicles.addVehicle(airplane);
                }
                else if (choiceVehicle == 2){
                    System.out.println("Enter ID : ");
                    id = input.next();
                    System.out.println("Enter Model : ");
                    model = input.next();
                    System.out.println("Enter Maximum Speed : ");
                    maxSpeed = input.nextDouble();
                    System.out.println("Enter Current Mileage : ");
                    currentMileage = input.nextDouble();
                    System.out.println("Enter Current Passengers Number : ");
                    currentPassenger = input.nextInt();
                    System.out.println("Enter Current Cargo Number : ");
                    currentCargo = input.nextDouble();

                    bus = new Bus(id, model, maxSpeed, currentMileage, currentPassenger ,currentCargo);
                    vehicles.addVehicle(bus);
                }
                else if (choiceVehicle== 3){
                    System.out.println("Enter ID : ");
                    id = input.next();
                    System.out.println("Enter Model : ");
                    model = input.next();
                    System.out.println("Enter Maximum Speed : ");
                    maxSpeed = input.nextDouble();
                    System.out.println("Enter Current Mileage : ");
                    currentMileage = input.nextDouble();
                    System.out.println("Enter Current Passengers Number : ");
                    currentPassenger = input.nextInt();

                    car = new Car(id, model, maxSpeed, currentMileage, currentPassenger);
                    vehicles.addVehicle(car);
                }
                else if (choiceVehicle == 4){
                    System.out.println("Enter ID : ");
                    id = input.next();
                    System.out.println("Enter Model : ");
                    model = input.next();
                    System.out.println("Enter Maximum Speed : ");
                    maxSpeed = input.nextDouble();
                    System.out.println("Enter Current Mileage : ");
                    currentMileage = input.nextDouble();
                    System.out.println("Has the cargo Sailed?(T/F) : ");
                    sailed = input.next();

                    if (sailed == "T"){
                        hasSailed = true;
                    }
                    else{
                        hasSailed = false;
                    }
                    cargoShip = new CargoShip(id, model, maxSpeed, currentMileage, hasSailed);
                    vehicles.addVehicle(cargoShip);
                }
                else if (choiceVehicle == 5){
                    System.out.println("Enter ID : ");
                    id = input.next();
                    System.out.println("Enter Model : ");
                    model = input.next();
                    System.out.println("Enter Maximum Speed : ");
                    maxSpeed = input.nextDouble();
                    System.out.println("Enter Current Mileage : ");
                    currentMileage = input.nextDouble();
                    System.out.println("Enter Current Cargo Number : ");
                    currentCargo = input.nextDouble();

                    truck = new Truck(id, model, maxSpeed, currentMileage, currentCargo);
                    vehicles.addVehicle(truck);
                }
                else{
                    System.out.println("Invalid entry, try again...");
                }

                System.out.println("Vehicle Added");
                break;

            case 2:
                System.out.println("Enter Vehicle ID to remove : ");
                vID = input.next();

                vehicles.removeVehicle(vID);
                System.out.println("Vehicle Removed");
                break;

            case 3:
                System.out.println("Enter the distance to start the journey : ");
                distance = input.nextDouble();
                vehicles.startAllJourney(distance);
                break;

            case 4:
                System.out.println("Enter the fuel amount : ");
                amount = input.nextDouble();

                vehicles.refuelAll(amount);
                break;

            case 5:
                vehicles.maintainAll();

                System.out.println("Maintenance done for all vehicles");
                break;

            case 6:
                System.out.println(vehicles.generateReport());
                break;

            case 7:
                fileHandler.safeToFile(vehicles, "vehicleDetails.csv");
                System.out.println("Details saved in file successfully");
                break;

            case 8:
                for (List<String> lst : fileHandler.loadFromFile("vehicleDetails.csv")){
                    if (lst.get(0).equals("Car")){
                        car = new Car(lst.get(1), lst.get(2), Double.parseDouble(lst.get(3)), Double.parseDouble(lst.get(7)),Integer.parseInt(lst.get(5)));
                        vehicles.addVehicle(car);
                    }
                    else if (lst.get(0).equals("Bus")){
                        bus = new Bus(lst.get(1), lst.get(2), Double.parseDouble(lst.get(3)), Double.parseDouble(lst.get(7)), Integer.parseInt(lst.get(5)) ,Double.parseDouble(lst.get(6)));
                        vehicles.addVehicle(bus);
                    }
                    else if (lst.get(0).equals("Airplane")){
                        airplane = new Airplane(lst.get(1), lst.get(2), Double.parseDouble(lst.get(3)), Double.parseDouble(lst.get(7)), Double.parseDouble(lst.get(10)));
                        vehicles.addVehicle(airplane);
                    }
                    else if (lst.get(0).equals("Truck")){
                        truck = new Truck(lst.get(1), lst.get(2), Double.parseDouble(lst.get(3)), Double.parseDouble(lst.get(7)), Double.parseDouble(lst.get(6)));
                        vehicles.addVehicle(truck);
                    }
                    else{
                        cargoShip = new CargoShip(lst.get(1), lst.get(2), Double.parseDouble(lst.get(3)), Double.parseDouble(lst.get(7)), Boolean.parseBoolean(lst.get(9)));
                        vehicles.addVehicle(cargoShip);
                    }
                }
                break;

            case 9:
                System.out.println(
                        "Which vehicle do you want to search by type : \n" +
                                "1. Airplane\n" +
                                "2. Bus\n" +
                                "3. Car\n" +
                                "4. Cargo Ship\n" +
                                "5. Truck"
                );

                choice = input.nextInt();

                if (choice == 1){
                    vehicles.searchByType(Airplane.class);
                }
                else if (choice == 2){
                    vehicles.searchByType(Bus.class);
                }
                else if (choice == 3){
                    vehicles.searchByType(Car.class);
                }
                else if (choice == 4){
                    vehicles.searchByType(CargoShip.class);
                }
                else if (choice == 5){
                    vehicles.searchByType(Truck.class);
                }
                else{
                    System.out.println("Invalid Input");
                }
                break;

            case 10:
                System.out.println("The following vehicles needs maintenance");
                for (Vehicle lst : vehicles.getVehiclesNeedingMaintenance()){
                    lst.getId();
                }
                break;

            case 11:
                System.out.println("Exiting...");
                break;

        default:
            System.out.println("Invalid input, try again.");
        }
    }
}
