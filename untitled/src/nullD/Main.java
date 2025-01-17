package nullD;

public class Main {

    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle vehicle = vehicleFactory.getVehicle("Car");
        System.out.println(vehicle.getNoOfWheels());
        System.out.println(vehicle.getNoOfPassengers());
        Vehicle vehicle1 = vehicleFactory.getVehicle("Bicycle");
        System.out.println(vehicle1.getNoOfWheels());
        System.out.println(vehicle1.getNoOfPassengers());
    }
}
