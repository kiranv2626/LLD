package visitor;

public class DeluxeRoom implements RoomElement {
    int price;
    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }
}
