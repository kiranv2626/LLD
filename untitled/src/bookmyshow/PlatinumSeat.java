package bookmyshow;

public class PlatinumSeat extends Seat{
    @Override
    public int getPrice() {
        return 200;
    }
    @Override
    public SeatType getSeatType() {
        return SeatType.PLATINUM;
    }
}
