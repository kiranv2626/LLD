package parkinglot.parkingspotmanager;

import parkinglot.parkingspot.ParkingSpot;
import parkinglot.parkingspot.TwoWheeler;
import parkinglot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class FixedTwo {
    List<ParkingSpot> parkingSpots = new ArrayList<>();
    public FixedTwo() {
        List<ParkingSpot> twoWheelerParkingSpots = new ArrayList<>();
        for(int i=0;i<10;i++) {
            ParkingSpot twoWheeler = new TwoWheeler();
            twoWheeler.setAvailable(true);
            twoWheeler.setParkingSpotNumber(i);
            twoWheeler.setVehicleType(VehicleType.TWO_WHEELER);
            twoWheelerParkingSpots.add(twoWheeler);
        }
        this.parkingSpots = twoWheelerParkingSpots;
    }
}
