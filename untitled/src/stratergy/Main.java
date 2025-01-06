package stratergy;

public class Main {
    public static void main(String[] args) {
        Vehicle SportsVehicle = new SportsVehicle();
        Vehicle OffLoadVehicle = new OffLoadVehicle();
        Vehicle GoodsVehicle = new GoodsVehicle();
        SportsVehicle.drive();
        OffLoadVehicle.drive();
        GoodsVehicle.drive();
    }
}
