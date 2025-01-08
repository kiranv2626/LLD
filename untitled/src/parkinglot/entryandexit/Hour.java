package parkinglot.entryandexit;

import parkinglot.ticket.Ticket;

public class Hour extends PricingStratergy {
    @Override
    public float getPrice(Ticket ticket) {
//        int hours = (int) (ticket.getEntryTime() / 1000 / 60 / 60);
//        int currentTime = (int) (System.currentTimeMillis() / 1000 / 60 / 60);
//        int totalhours = currentTime - hours;
//        return totalhours * ticket.getParkingSpot().getPrice();
        return ticket.getParkingSpot().getPrice();
    }
}
