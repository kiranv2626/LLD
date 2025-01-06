package notify;

public class PhoneObserver implements Observer {
    String userName;
    StockObservable stockObservable;
    public PhoneObserver(String userName, StockObservable stockObservable) {
        this.userName = userName;
        this.stockObservable = stockObservable;
    }

    public void update() {
        sendMsg(userName, "product stock is updated");
    }

    public void sendMsg(String userName, String msg) {
        System.out.println("Sending msg to " + userName );
    }
}
