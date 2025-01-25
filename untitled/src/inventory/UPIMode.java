package inventory;

public class UPIMode implements PaymentMode{
    @Override
    public boolean makePayment() {
        System.out.println("Payment made is through UPI");
        return true;
    }
}
