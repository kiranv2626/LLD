package nullD;

public class Car implements Vehicle {
    @Override
    public int getNoOfWheels() {
        return 4;
    }
    @Override
    public int getNoOfPassengers() {
        return 4;
    }
}
