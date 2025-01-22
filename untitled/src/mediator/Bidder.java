package mediator;

public class Bidder implements Colleague{
    String name;
    AuctionMediator mediator;

    public Bidder(String name, AuctionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        this.mediator.addBidder(this);
    }

    @Override
    public void placebid(int bid) {
        this.mediator.placeBid( this,bid);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void getbid(int bid) {
        System.out.println(this.name + " received a bid of " + bid);
    }
}
