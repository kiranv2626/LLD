package inventory;

import java.util.Map;

public class Order {
    User user;
    Address address;
    Map<Integer, Integer> categoryIdvsCount;
    WareHouse wareHouse;
    Invoice invoice;
    Payment payment;
    OrderStatus orderStatus;
    public Order(User user,WareHouse wareHouse) {
        this.user=user;
        this.wareHouse=wareHouse;
        this.categoryIdvsCount=user.getCart().getCartItems();
        this.invoice=new Invoice();

        invoice.generateInvoice(this);
        this.orderStatus=OrderStatus.PENDING;


    }

    public void checkout(){
        wareHouse.removeItemFromInventory(categoryIdvsCount);
        boolean paymentStatus=makePayment(new UPIMode());
        if(paymentStatus){
            orderStatus=OrderStatus.DELIVERED;
            user.getCart().emptyCart();
        }
        else
        {
            wareHouse.addItemstoCart(categoryIdvsCount);
        }
    }

    public boolean makePayment(PaymentMode paymentMode){
        payment=new Payment(paymentMode);
        return payment.makePayment();
    }

    public void generateInvoice(){
        invoice.generateInvoice(this);
    }
}
