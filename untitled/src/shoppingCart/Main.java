package shoppingCart;

public class Main {
    public static void main(String[] args) {
        shoppingcart cart = new shoppingcart();
        cart.addCart(new Item1("Item 1", 1000.0, ProductType.Electronics));
        cart.addCart(new Item2("Item 2", 2000.0, ProductType.Electronics));
        cart.getTotal();
    }
}
