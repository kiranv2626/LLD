package visitor;

public class Main {
    public static void main(String[] args) {
        RoomElement roomElement = new SingleRoom();
        RoomVisitor roomVisitor = new PricingVisitor();
        roomElement.accept(roomVisitor);
        RoomElement roomElement1 = new DeluxeRoom();
        roomElement1.accept(roomVisitor);
        RoomElement roomElement2 = new DoubleRoom();
        roomElement2.accept(roomVisitor);

        RoomVisitor roomVisitor1 = new MaintainVisitor();
        roomElement.accept(roomVisitor1);
        roomElement1.accept(roomVisitor1);
        roomElement2.accept(roomVisitor1);
    }
}
