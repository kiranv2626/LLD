package parkinglot.parkingstratergy;

import parkinglot.parkingspot.ParkingSpot;
import parkinglot.vehicle.Vehicle;
import java.util.List;

public class defaults implements ParkingStratergy {
    @Override
    public ParkingSpot findParkingSpot(Vehicle vehicle, List<ParkingSpot> parkingSpots) {
        ParkingSpot closestSpot = null;

        for (ParkingSpot spot : parkingSpots) {
            // Only consider available spots
            if (spot.isAvailable()) {
                // If this is the first spot found or closer spot, update

                    closestSpot = spot;
                    break;

            }
        }

        return closestSpot;
    }

}