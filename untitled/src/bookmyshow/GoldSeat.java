package bookmyshow;

public class GoldSeat extends Seat {
    @Override
    public int getPrice() {
        return 150;
    }
    @Override
    public SeatType getSeatType() {
        return SeatType.GOLD;
    }
}
