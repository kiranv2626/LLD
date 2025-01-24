package visitor;

public class DoubleRoom implements RoomElement {
    int price;
    @Override
    public void accept(RoomVisitor visitor) {
        System.out.println("Double Room");
        visitor.visit(this);
    }
}
