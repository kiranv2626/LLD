package stratergy;

public class GoodsVehicle extends Vehicle{
//    @Override
//    public void drive() {
//        System.out.println("driving a sports model");
//    }
    GoodsVehicle(){
        super(new SportsStratergy());
    }
}
