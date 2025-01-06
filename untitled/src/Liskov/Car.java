package Liskov;

public class Car extends EngineVehicle {
    @Override
    public int getNoOfWheels() {
        return 4;
    }
}
