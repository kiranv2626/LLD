package parkinglot.parkingspotmanager;

import parkinglot.parkingspot.FourWheeler;
import parkinglot.parkingspot.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class FourWheelerManager extends ParkingManger {
    private static boolean initialized = false;

    public FourWheelerManager() {
        super(new ArrayList<>());
        if (!initialized) {
            initializeFourWheelerSpots();
            initialized = true; // Set the flag to true after initialization
        }
    }

    private void initializeFourWheelerSpots() {
        for (int i = 11; i <= 20; i++) {
            FourWheeler spot = new FourWheeler();
            spot.setParkingSpotNumber(i);
            spot.setAvailable(true);
            addParkingSpot(spot); // Use parent class method to add spots
        }
    }
}
