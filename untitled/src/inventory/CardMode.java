package inventory;

public class CardMode implements PaymentMode {
    @Override
    public boolean makePayment() {
        System.out.println("Payment made using Card");
        return true;
    }
}
