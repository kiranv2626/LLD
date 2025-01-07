package absFactory;

public class Main {

  public static void main(String[] args) {
      Vehicle vehicle = new LuxaryFactory().getVehicle();
      vehicle.getVehicleType();
      Vehicle vehicle1 = new OrdinaryFactory().getVehicle();
      vehicle1.getVehicleType();
  }

}
