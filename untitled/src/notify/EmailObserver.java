package notify;

public class EmailObserver implements Observer {
    String emailId;
    StockObservable stockObservable;
    public EmailObserver(String emailId, StockObservable stockObservable) {
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }
    public void update() {
        sendEmail(emailId, "product stock is updated");
    }
    public void sendEmail(String emailId, String msg) {
        System.out.println("Sending email to " + emailId + " with message: " + msg);
    }
}
