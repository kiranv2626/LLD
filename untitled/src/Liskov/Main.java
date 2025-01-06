package Liskov;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new Bicycle());
        vehicles.add(new MotorCycle());
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getNoOfWheels());
        }
        List<EngineVehicle>   engineVehicleList = new ArrayList<>();
        engineVehicleList.add(new Car());
        engineVehicleList.add(new MotorCycle());
        for (EngineVehicle engineVehicle : engineVehicleList) {
            System.out.println(engineVehicle.hasEngine());
        }
    }
}
