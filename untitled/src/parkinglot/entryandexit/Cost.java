package parkinglot.entryandexit;

import parkinglot.ticket.Ticket;

public class Cost {
    PricingStratergy pricingStratergy;

    public Cost(PricingStratergy pricingStratergy) {
        this.pricingStratergy = pricingStratergy;
    }

    public float calculateCost(Ticket ticket) {
        return pricingStratergy.getPrice(ticket);
    }
}
