# AP_M25_A1
Transportation Fleet Management System, Advanced Programming Assignment-1

Q. **Explain how your code demonstrates inheritance, polymorphism, abstract classes,
and interfaces.**
~ In this project, we have a superclass Vehicle. This is the most general class. This class contains methods which are common in every type of vehicle present in the world. This class is abstract so that child classes can implement the methods.
~ The Vehicle class is broken down into further specialisation of vehicles, such as air vehicle, land vehicle and water vehicle. The AirVehicle, LandVehicle and WaterVehicle inherits the main Vehicle class. They implement some of the methods from the Vehicle class and therefore these classes are also declared abstract. Some methods such as getFuelLevel are different for every vehicle, so it is declared abstract.
~ The subclasses of Vehicle class are further broken down into more specialised vehicle such as a car or a bus. Now, these classes Car, Bus, Airplane, Truck, Cargoship are concrete classes as they implment all the methods of the parent abstract class.



. Subclasses AirVehicle, LandVehicle, WaterVehicle inherits Vehicle.

– Provide clear instructions to compile (e.g., javac *.java), run (e.g., java Main),
and test persistence with the sample CSV.

– Describe how to use the CLI and demo features (e.g., add vehicles, simulate jour-
ney, save/load).

– Include a brief walkthrough of running the demo and expected output.
