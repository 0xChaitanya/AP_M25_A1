# AP_M25_A1
Transportation Fleet Management System, Advanced Programming Assignment-1

**Q. Explain how your code demonstrates inheritance, polymorphism, abstract classes,
and interfaces.**
<br>
~ In this project, we have a superclass Vehicle. This is the most general class. This class contains methods which are common in every type of vehicle present in the world. This class is abstract so that child classes can implement the methods.
<br>
~ The Vehicle class is broken down into further specialisation of vehicles, such as air vehicle, land vehicle and water vehicle. The AirVehicle, LandVehicle and WaterVehicle inherits the main Vehicle class. They implement some of the methods from the Vehicle class and therefore these classes are also declared abstract. Some methods such as getFuelLevel are different for every vehicle, so it is declared abstract.
<br>
~ The subclasses of Vehicle class are further broken down into more specialised vehicle such as a car or a bus. Now, these classes Car, Bus, Airplane, Truck, Cargoship are concrete classes as they implment all the methods of the parent abstract class.
<br>
<br>

Q. Provide clear instructions to compile (e.g., javac *.java), run (e.g., java Main), and test persistence with the sample CSV. <br>

Steps to run the program: <br>
Step1: Go to the main directory which is AP_M25_A1 class <br>
Step2: On the terminal, type "javac Main.java" (This will compile all the classes, interfaces in this project) <br>
Step3: Now, type "java Main" (This will start the project) <br> <br>

**Q. Describe how to use the CLI and demo features (e.g., add vehicles, simulate jour-
ney, save/load).** <br>
Once the project starts, you will see a serialised menu, use the serial numbers to perform the actions give on the right of the serial number. <br>