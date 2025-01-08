package parkinglot;

import parkinglot.entryandexit.EntryGate;
import parkinglot.entryandexit.Exit;
import parkinglot.parkingspot.FourWheeler;
import parkinglot.parkingspot.ParkingSpot;
import parkinglot.parkingspot.TwoWheeler;
import parkinglot.parkingspotmanager.FourWheelerManager;
import parkinglot.parkingspotmanager.ParkingManagerFactory;
import parkinglot.parkingspotmanager.ParkingManger;
import parkinglot.parkingspotmanager.TwoWheelerManger;
import parkinglot.ticket.Ticket;
import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(1,VehicleType.TWO_WHEELER);
        Vehicle vehicle1 = new Vehicle(2,VehicleType.FOUR_WHEELER);
        EntryGate entryGate = new EntryGate();
        Ticket ticket = entryGate.bookSpot(vehicle,"CloseToEntry");
        Ticket ticket1 = entryGate.bookSpot(vehicle1,"CloseToEntry");
        System.out.println("parking spot number t "+ticket.getParkingSpot().getParkingSpotNumber());
        System.out.println("Entry time is t "+ticket.getEntryTime());
        System.out.println("Vehhicle number t "+ticket.getVehicle().getVehicleNumber());
        System.out.println("parking spot number t1 "+ticket.getParkingSpot().getParkingSpotNumber());
        System.out.println("Entry time is t1 "+ticket1.getEntryTime());
        System.out.println("Vehhicle number t1 "+ticket1.getVehicle().getVehicleNumber());
        Exit exit = new Exit(ticket);
        Exit exit1 = new Exit(ticket1);
        exit.doPayment();
        exit1.doPayment();
        System.out.println("is parking spot available t "+ticket.getParkingSpot().isAvailable());
        System.out.println("is parking spot available t1"+ticket1.getParkingSpot().isAvailable());
    }
}
