import java.util.Scanner;
import ConcreteClasses.*;
import Exceptions.*;

public class Main {
    public static void main(String[] args) throws InvalidOperationException {
        Scanner input = new Scanner(System.in);
        FleetManager vehicles = new FleetManager();

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

        //Variables in USE
        int choice = input.nextInt();
        String id;
        String model;
        double maxSpeed;
        double currentMileage;
        double maxAltitude;
        int currentPassenger;
        double currentCargo;

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

                    Airplane airplane = new Airplane(id, model, maxSpeed, currentMileage, maxAltitude);
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

                    Bus bus = new Bus(id, model, maxSpeed, currentMileage, currentPassenger ,currentCargo);
                    vehicles.addVehicle(bus);
                }
                else if (choiceVehicle== 3){

//                    public Bus(String id, String model, double maxSpeed, double currentMileage, int currentPassengers ,double currentCargo){
//                super(id, model, maxSpeed, currentMileage, 4);
//                this.currentPassengers = currentPassengers;
//                this.currentCargo = currentCargo;
            }

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
        default:
        }

    }
}
