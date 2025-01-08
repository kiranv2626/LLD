package parkinglot.entryandexit;

import parkinglot.ticket.Ticket;

public class Default extends PricingStratergy {
    @Override
    public float getPrice(Ticket ticket) {
        return ticket.getParkingSpot().getPrice();
    }
}
