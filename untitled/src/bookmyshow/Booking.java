package bookmyshow;

import java.util.List;

public class Booking {
    int bookingId;
    List<Seat> seats;
    Payment payment;
    Show show;

    public Booking(int bookingId, List<Seat> seats, Payment payment, Show show) {
        this.bookingId = bookingId;
        this.seats = seats;
        this.payment = payment;
        this.show = show;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

}
