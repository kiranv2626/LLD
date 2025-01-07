package absFactory;

public class LuxaryFactory implements VehicleFactory {
    @Override
    public Vehicle getVehicle() {
        return new LuxuaryVehicle();
    }
}
