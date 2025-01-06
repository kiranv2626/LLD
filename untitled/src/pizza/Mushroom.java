package pizza;

public class Mushroom extends DecorFactory{
    BasePizza pizza;
    public Mushroom(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return pizza.cost() +  20;
    }
}
