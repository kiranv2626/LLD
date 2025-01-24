package visitor;

public class SingleRoom implements RoomElement {
    int price;
    @Override
    public void accept(RoomVisitor visitor) {
        System.out.println("Visiting SingleRoom");
        visitor.visit(this);
    }
}
