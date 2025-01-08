package parkinglot.ticket;

import parkinglot.parkingspot.ParkingSpot;
import parkinglot.vehicle.Vehicle;

public class Ticket {
    long entryTime;
    Vehicle vehicle;
    ParkingSpot parkingSpot;
    public Ticket(long entryTime, Vehicle vehicle, ParkingSpot parkingSpot){
        this.entryTime=entryTime;
        this.vehicle=vehicle;
        this.parkingSpot=parkingSpot;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
