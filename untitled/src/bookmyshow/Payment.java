package bookmyshow;

public class Payment {
    PaymentStatus paymentStatus;

    public Payment(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public boolean doPayment(int amount){
        System.out.println("Payment Done for amount "+amount);
        paymentStatus=PaymentStatus.Success;
        return true;
    }
}
