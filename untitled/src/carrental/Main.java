package carrental;

import pizza.VegDelight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        List<User> users = new ArrayList<User>();
        List<Store> stores = new ArrayList<Store>();
        Vehicle v1=new Vehicle();
        v1.setId("1");
        Vehicle v2=new Vehicle();
        v2.setId("2");
        vehicles.add(v1);
        vehicles.add(v2);
        User u1=new User();
        u1.setId(1);
        User u2=new User();
        u2.setId(2);
        users.add(u1);
        users.add(u2);
        Store s1=new Store();
        s1.setId(1);
        s1.setVehicles(vehicles);
        stores.add(s1);
        VehicelRentalSystem vehicelRentalSystem=new VehicelRentalSystem(stores,users);
        Location location = new Location( "","Bangalore", "Karnataka", "India","403012");
        Store store = vehicelRentalSystem.getStore(location);
        Reservation reservation = store.createReservation(v1,u1);
        System.out.println(reservation);
        Bill bill = new Bill(reservation);
        System.out.println(bill);
        Payment payment = new Payment(bill);
        payment.doPayment();
        System.out.println("Booking Complete");;
        store.completeReservation(reservation);
        System.out.println(store.bills.get(reservation).paid);


    }
}
