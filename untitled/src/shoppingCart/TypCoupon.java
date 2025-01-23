package shoppingCart;

import java.util.ArrayList;
import java.util.List;

public class TypCoupon extends Coupon {
    Product product;
    int percentage;
    ProductType productType;
    public static List<ProductType> eligibleTypes= new ArrayList<>();
    static {
        eligibleTypes.add(ProductType.Electronics);
        eligibleTypes.add(ProductType.Clothing);
    }
    public TypCoupon(Product product, int percentage, ProductType productType) {
        this.product = product;
        this.percentage = percentage;
        this.productType = productType;
    }
    @Override
    public double getPrice() {
        if(eligibleTypes.contains(productType))
        {   //System.out.println("reducing price by TypCoupon"+product.getPrice()*percentage/100);
            return (product.getPrice()-product.getPrice()*percentage/100);
        }else{
            return product.getPrice();
        }
    }
}

