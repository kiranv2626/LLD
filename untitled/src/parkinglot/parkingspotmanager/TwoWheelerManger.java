package parkinglot.parkingspotmanager;
import parkinglot.parkingspot.ParkingSpot;
import parkinglot.parkingspot.TwoWheeler;
import parkinglot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;


public class TwoWheelerManger extends ParkingManger {
    private static boolean initialized = false;

    public TwoWheelerManger() {
        super(new ArrayList<>());
        if (!initialized) {
            initializeTwoWheelerSpots();
            initialized = true; // Set the flag to true after initialization
        }
    }

    private void initializeTwoWheelerSpots() {
        for (int i = 0; i <= 10; i++) {
            TwoWheeler spot = new TwoWheeler();
            spot.setParkingSpotNumber(i);
            spot.setAvailable(true);
            addParkingSpot(spot); // Use parent class method to add spots
        }
    }
}