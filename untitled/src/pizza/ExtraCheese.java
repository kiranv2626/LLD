package pizza;

public class ExtraCheese extends DecorFactory{
    BasePizza pizza;

    public ExtraCheese(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return pizza.cost() +  10;
    }
}
