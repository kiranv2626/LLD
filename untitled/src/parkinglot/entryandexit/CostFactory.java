package parkinglot.entryandexit;

import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

public class CostFactory {
    Cost getCost(Vehicle vehicle){
        if(vehicle.getVehicleType().equals(VehicleType.TWO_WHEELER)){
            return new TwoCost();
        }
        else if(vehicle.getVehicleType().equals(VehicleType.FOUR_WHEELER)){
            return new FourCost();
        }
        return null;

    }
}
