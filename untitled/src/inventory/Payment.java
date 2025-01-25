package inventory;

public class Payment {
    PaymentMode paymentMode;
    public Payment(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
    public boolean makePayment() {
        paymentMode.makePayment();
        return true;
    }
}
