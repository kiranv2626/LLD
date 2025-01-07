package absFactory;

public class OrdinaryFactory implements VehicleFactory {
    @Override
    public Vehicle getVehicle() {
        return new OrdinaryVehicle();
    }
}
