package parkinglot.parkingspotmanager;

import parkinglot.vehicle.VehicleType;

public class ParkingManagerFactory {
     public static ParkingManger getParkingManager(VehicleType vehicleType){
        if(vehicleType==VehicleType.TWO_WHEELER) {
            return new TwoWheelerManger();
        }
        if(vehicleType==VehicleType.FOUR_WHEELER) {
            return new FourWheelerManager();
        }
        return null;


    }
}
