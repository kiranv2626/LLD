package carrental;

public class Vehicle {
    String id;
    String vehicleType;
    String Make;
    String Model;
    int year;
    int priceOfDay;
    int priceOfHour;
    Status status;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPriceOfDay() {
        return priceOfDay;
    }

    public void setPriceOfDay(int priceOfDay) {
        this.priceOfDay = priceOfDay;
    }

    public int getPriceOfHour() {
        return priceOfHour;
    }

    public void setPriceOfHour(int priceOfHour) {
        this.priceOfHour = priceOfHour;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
