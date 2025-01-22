package mediator;

public class Main {

    public static void main(String[] args) {
        AuctionMediator auctionMediator = new Auction();
        Bidder bidder1 = new Bidder("Bidder1", auctionMediator);
        Bidder bidder2 = new Bidder("Bidder2", auctionMediator);
        Bidder bidder3 = new Bidder("Bidder3", auctionMediator);
        Bidder bidder4 = new Bidder("Bidder4", auctionMediator);
        Bidder bidder5 = new Bidder("Bidder5", auctionMediator);

        bidder1.placebid(100);
        bidder2.placebid(200);
    }
}
