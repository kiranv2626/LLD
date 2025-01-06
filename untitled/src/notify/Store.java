package notify;

public class Store {
    public static void main(String[] args) {
        IphoneObservable iphoneObservable = new IphoneObservable();

        PhoneObserver phoneObserver1 = new PhoneObserver("user1", iphoneObservable);
        PhoneObserver phoneObserver2 = new PhoneObserver("user2", iphoneObservable);
        EmailObserver emailObserver1 = new EmailObserver("email1", iphoneObservable);
        EmailObserver emailObserver2 = new EmailObserver("email2", iphoneObservable);

        iphoneObservable.addObserver(phoneObserver1);
        iphoneObservable.addObserver(phoneObserver2);
        iphoneObservable.addObserver(emailObserver1);
        iphoneObservable.addObserver(emailObserver2);

        iphoneObservable.setStock(10);

    }
}
