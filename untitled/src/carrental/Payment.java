package carrental;

import java.util.UUID;

public class Payment {
    int id;
    String paymentType;
    double price;
    Payment(Bill bill){
        id= UUID.randomUUID().hashCode();
        paymentType="CASH";
        price=bill.getAmount();
    }
    public void doPayment(){
        System.out.println("Payment Done");

    }
}
