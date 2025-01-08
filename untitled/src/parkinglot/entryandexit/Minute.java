package parkinglot.entryandexit;

import parkinglot.ticket.Ticket;

public class Minute extends PricingStratergy{
    @Override
    public float getPrice(Ticket ticket) {
//        int minute=(int) ((System.currentTimeMillis()-ticket.getEntryTime())/60000);
//        return ticket.getParkingSpot().getPrice()*minute;
        return ticket.getParkingSpot().getPrice();
    }
}
