package nullD;

public class NullVehicle implements Vehicle {
    @Override
    public int getNoOfWheels() {
        return 0;
    }
    @Override
    public int getNoOfPassengers() {
        return 0;
    }
}
