package visitor;

public class MaintainVisitor implements RoomVisitor {
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Maintaining Single Room");
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Maintaining Double Room");
    }

    @Override
    public void visit(DeluxeRoom deluxeRoom) {
        System.out.println("Maintaining Deluxe Room");
    }
}
