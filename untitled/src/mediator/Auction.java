package mediator;

import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator {
    List<Colleague> colleagues ;

    public Auction() {
        colleagues = new ArrayList<Colleague>();
    }

    @Override
    public void addBidder(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void placeBid(Colleague colleague, int amount) {
        System.out.println(colleague.getName() + " placed a bid of " + amount);
        for (Colleague c : colleagues) {
            if (c != colleague) {
                c.getbid(amount);
            }
        }
    }
}
