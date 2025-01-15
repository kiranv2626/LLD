package carrental;

public class Bill {
    Reservation reservation;
    double amount;
    boolean paid;
    Bill(Reservation reservation){
        this.reservation=reservation;
        this.amount=compute();
        this.paid=false;
    }
    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    public double compute(){
        return 100.0;
    }
}
