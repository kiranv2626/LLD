package carrental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Store {
    int id;
    VehicleInventory vehicleInventory ;
    Location location;
    List<Reservation> reservations=new ArrayList<Reservation>();
    HashMap<Reservation,Bill> bills=new HashMap<Reservation,Bill>();

    public void setVehicles(List<Vehicle> vehicles) {
        vehicleInventory=new VehicleInventory(vehicles);
    }
    public void getVehicles(){
        vehicleInventory.getVehicles();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleInventory getVehicleInventory() {
        return vehicleInventory;
    }

    public void setVehicleInventory(VehicleInventory vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    public Reservation createReservation(Vehicle vehicle, User user){
        Reservation reservation=new Reservation(vehicle,user);
        reservations.add(reservation);
        Bill bill=new Bill(reservation);
        bills.put(reservation,bill);
        return reservation;

    }

    public void completeReservation(Reservation reservation){
        reservation.setReservationStatus(ReservationStatus.COMPLETED);
        Bill bill= bills.get(reservation);
        bill.setPaid(true);
        vehicleInventory.removeVehicle(reservation.getVehicle());

    }
}
