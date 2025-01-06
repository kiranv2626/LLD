package stratergy;

public class Vehicle {
    DriveStratergy driveStratergy;
    Vehicle(DriveStratergy driveStratergy) {
        this.driveStratergy = driveStratergy;
    }
    public void drive() {
        driveStratergy.drive();
    }
//    public void drive() {
//        System.out.println("Vehicle is driving in normal mode");
//    }
}
