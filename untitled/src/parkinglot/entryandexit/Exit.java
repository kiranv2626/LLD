package parkinglot.entryandexit;

import parkinglot.parkingspotmanager.ParkingManagerFactory;
import parkinglot.parkingspotmanager.ParkingManger;
import parkinglot.payment.Pyament;
import parkinglot.ticket.Ticket;

public class Exit {
    Ticket ticket;
    CostFactory costFactory;
    ParkingManagerFactory parkingMangerFactory;
    Pyament pyament;
    public Exit(Ticket ticket){
        this.ticket=ticket;
        this.costFactory=new CostFactory();
        this.parkingMangerFactory=new ParkingManagerFactory();
        this.pyament=new Pyament();
    }
    public float calculateCost(){
        Cost cost=costFactory.getCost(ticket.getVehicle());
        return cost.calculateCost(ticket);
    }
    public void doPayment(){
        float price=calculateCost();
        System.out.println("price of the booking is "+price);
        pyament.doPayment("cash",price);
        ParkingManger parkingManger=ParkingManagerFactory.getParkingManager(ticket.getVehicle().getVehicleType());
        parkingManger.removeVehicle(ticket.getVehicle(),ticket.getParkingSpot());
    }
}
