package bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class BookingController {



    public void book(Booking booking) {
        List<Seat> seats = booking.getSeats();
        int price = calculatePrice(seats);
        booking.payment.doPayment(price);
        if(booking.payment.paymentStatus==PaymentStatus.Success){
            for (Seat seat : seats) {
                seat.setBooked(true);
               List<Seat> bookedSeats = booking.show.getBookedSeats()==null?new ArrayList<>():booking.show.getBookedSeats();
                bookedSeats.add(seat);
                booking.show.setBookedSeats(bookedSeats);

            }

        }
    }
    public int calculatePrice(List<Seat> seats) {
        int price = 0;
        for (Seat seat : seats) {
            price += seat.getPrice();
        }
        return price;
    }
}
