package nullD;

public class VehicleFactory {
    Vehicle getVehicle(String vehicleType){
        if(vehicleType.equalsIgnoreCase("car")){
            return new Car();
        }
        return new NullVehicle();

    }
}
