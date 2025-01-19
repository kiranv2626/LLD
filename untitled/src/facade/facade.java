package facade;

import javax.management.Notification;

public class facade {
    Payment payment ;
    Notifications notifications;
    ProductDao productDao;
    public facade()
    {
        payment = new Payment();
        notifications = new Notifications();
        productDao = new ProductDao();
    }
    public void buyProduct(String productName)
    {
        productDao.getProduct();
        payment.makePayment();
        notifications.sendNotification(productName);
    }
}
