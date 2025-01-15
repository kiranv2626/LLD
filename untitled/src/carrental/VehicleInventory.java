package carrental;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventory {
    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    VehicleInventory(List<Vehicle> vehicles){
        this.vehicles=vehicles;
    }
    public List<Vehicle> getVehicles(){
        return vehicles;
    }
    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
    }
}
