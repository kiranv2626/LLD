package shoppingCart;

import java.util.ArrayList;
import java.util.List;

public class shoppingcart {
    List<Product> productList ;

    public shoppingcart() {
        this.productList = new ArrayList<>();
    }

    public void addCart(Product product){
        Product Dicounted= new TypCoupon(new PerCoupon(product,10),10,product.productType);
        productList.add(Dicounted);
    }

    public void getTotal(){
        double total=0;
        for(int i=0;i<productList.size();i++)
        {
            total=total+productList.get(i).getPrice();
        }
        System.out.println(total);
    }

}
