package parkinglot.parkingstratergy;

import parkinglot.parkingspot.ParkingSpot;
import parkinglot.vehicle.Vehicle;
import java.util.List;

public interface ParkingStratergy {
    ParkingSpot findParkingSpot(Vehicle vehicle, List<ParkingSpot> parkingSpotList) ;
}
