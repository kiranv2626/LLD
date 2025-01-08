package parkinglot.parkingspot;
import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

public class ParkingSpot {
    public int parkingSpotNumber;
    public boolean isAvailable;
    public VehicleType vehicleType;
    public Vehicle vehicle;
    public float price;

    public void parkVehicle(Vehicle vehicle){
      this.vehicle=vehicle;
      this.isAvailable=false;
    }
    public void removeVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
        this.isAvailable=true;
    }

    public int getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(int parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
