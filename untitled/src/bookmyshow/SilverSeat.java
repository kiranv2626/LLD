package bookmyshow;

public class SilverSeat extends Seat {
    @Override
    public int getPrice() {
        return 100;
    }
    @Override
    public SeatType getSeatType() {
        return SeatType.SILVER;
    }
}
