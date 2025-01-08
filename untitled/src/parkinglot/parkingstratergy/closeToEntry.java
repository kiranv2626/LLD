package parkinglot.parkingstratergy;

import parkinglot.parkingspot.ParkingSpot;
import parkinglot.vehicle.Vehicle;
import java.util.List;

public class closeToEntry implements ParkingStratergy {
    @Override
    public ParkingSpot findParkingSpot(Vehicle vehicle, List<ParkingSpot> parkingSpots) {
        ParkingSpot closestSpot = null;
        System.out.println("close to entry");
        System.out.println(parkingSpots.size());
        for (ParkingSpot spot : parkingSpots) {
            // Only consider available spots
            if (spot.isAvailable()) {
                // If this is the first spot found or closer spot, update
                if (closestSpot == null || spot.getParkingSpotNumber() < closestSpot.getParkingSpotNumber()) {
                    closestSpot = spot;
                }
            }
        }

        return closestSpot;
    }

}
