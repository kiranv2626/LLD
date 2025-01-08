package parkinglot.parkingstratergy;

public class ParkingStratergFactory {
    public ParkingStratergy getParkingStratergy(String stratergyType){
        switch (stratergyType){
            case "CloseToEntry":
                return new closeToEntry();
            case "CloseToExit":
                return new closeToExit();
            default:
                return new defaults();
        }
    }
}
