package parkinglot.entryandexit;

import parkinglot.ticket.Ticket;

public class PricingStratergy {
    float getPrice(Ticket ticket) {
        return ticket.getParkingSpot().getPrice();
    }
}
