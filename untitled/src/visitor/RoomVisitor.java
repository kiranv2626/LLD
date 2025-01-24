package visitor;

public interface RoomVisitor {
    void visit(SingleRoom singleRoom);
    void visit(DoubleRoom doubleRoom);
    void visit(DeluxeRoom deluxeRoom);
}
