package parkinglot.entryandexit;

import parkinglot.parkingspot.ParkingSpot;
import parkinglot.parkingspotmanager.ParkingManagerFactory;
import parkinglot.parkingspotmanager.ParkingManger;
import parkinglot.ticket.Ticket;
import parkinglot.vehicle.Vehicle;

public class EntryGate {
    ParkingManagerFactory parkingManagerFactory;

    public Ticket bookSpot(Vehicle vehicle, String Stratergy) {
        parkingManagerFactory = new ParkingManagerFactory();
        ParkingManger parkingManger = parkingManagerFactory.getParkingManager(vehicle.getVehicleType());
        System.out.println(parkingManger.toString());
        ParkingSpot ps= parkingManger.findParkingSpot(vehicle, Stratergy);
        System.out.println(ps.getParkingSpotNumber());
        parkingManger.parkVehicle(vehicle,ps);
        Ticket ticket=raiseTicket(vehicle,ps);
        return ticket;

    }
    public Ticket raiseTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        Ticket t1=new Ticket(System.currentTimeMillis(),vehicle,parkingSpot);
        return t1;
    }

}
