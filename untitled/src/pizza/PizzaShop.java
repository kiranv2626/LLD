package pizza;

public class PizzaShop {
    public static void main(String[] args) {
        BasePizza pizza = new Margharita();
        pizza = new Mushroom(pizza);
        pizza = new ExtraCheese(pizza);
        System.out.println("cost of pizza is: " + pizza.cost());
        BasePizza pizza1 = new VegDelight();
        pizza1 = new Mushroom(pizza1);
        pizza1 = new ExtraCheese(pizza1);
        System.out.println("cost of pizza is: " + pizza1.cost());
    }
}
