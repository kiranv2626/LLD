package visitor;

public class PricingVisitor implements RoomVisitor{

    @Override
    public void visit(SingleRoom element) {

        element.price = 100;
        System.out.println("Single Room Price: "+element.price);


    }

    @Override
    public void visit(DoubleRoom element) {

        element.price = 200;
        System.out.println("Double Room Price: "+element.price);

    }

    @Override
    public void visit(DeluxeRoom element) {

        element.price = 300;
        System.out.println("Deluxe Room Price: "+element.price);
    }
}
