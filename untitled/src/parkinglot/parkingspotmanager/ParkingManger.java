package parkinglot.parkingspotmanager;

import parkinglot.parkingspot.ParkingSpot;
import parkinglot.parkingstratergy.ParkingStratergFactory;
import parkinglot.parkingstratergy.ParkingStratergy;
import parkinglot.vehicle.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class ParkingManger {
    List<ParkingSpot> parkingSpots = new ArrayList<>();
    ParkingStratergFactory parkingStratergFactory = new ParkingStratergFactory();
    ParkingManger(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
    public ParkingSpot findParkingSpot(Vehicle vehicle, String stratergy) {
        ParkingStratergy parkingStratergy=parkingStratergFactory.getParkingStratergy(stratergy);
        System.out.println(parkingStratergy.toString());
        ParkingSpot ps= parkingStratergy.findParkingSpot(vehicle, parkingSpots);
        return ps;
    }
    public void addParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.add(parkingSpot);
    }

    void removeParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.remove(parkingSpot);
    }
    public void parkVehicle(Vehicle vehicle, ParkingSpot ps) {

        ps.parkVehicle(vehicle);
    }
    public void removeVehicle(Vehicle vehicle,ParkingSpot parkingSpot) {
        parkingSpot.removeVehicle(vehicle);
    }

}
