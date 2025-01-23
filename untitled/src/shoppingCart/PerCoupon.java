package shoppingCart;

public class PerCoupon extends Coupon {
    Product product;
    int percentage;

    public PerCoupon(Product product, int percentage) {
        this.product = product;
        this.percentage = percentage;
    }

    @Override
    public double getPrice() {
        //System.out.println("reducing price by PerCoupon"+product.getPrice()*percentage/100);
        return (product.getPrice()-product.getPrice()*percentage/100);
    }
}
