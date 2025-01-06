package notify;
import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements StockObservable {
    List<Observer> observers = new ArrayList<>();
    float stockCount=0;
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    @Override
    public void setStock(float nc) {
        if(stockCount==0)
        notifyObserver();
        stockCount+=nc;
    }
    @Override
    public float getStcock() {
        return stockCount;
    }
}
