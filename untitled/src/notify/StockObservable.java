package notify;

public interface StockObservable {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();


    public void setStock(float nc);

    public float getStcock();
}
