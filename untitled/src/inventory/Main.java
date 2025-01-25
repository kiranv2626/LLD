package inventory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WareHouse wareHouse=new WareHouse(new Inventory(),new Address("Buffalo","14226","NY"));
        Inventory inventory=wareHouse.getInventory();
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryName("Electronics");
        productCategory.setPrice(1000);
        inventory.addCategory(1,"Electronics",1000);
        inventory.addProduct(1,new Product(1,"Laptop"));
        inventory.addProduct(1,new Product(2,"Laptop1"));
        inventory.addProduct(1,new Product(3,"Laptop2"));

        User user=new User();
        user.setUserId(1);
        user.setUserName("Vishal");
        user.setAddress(new Address("Buffalo","14226","NY"));

        List<User> users=new ArrayList<>();
        users.add(user);
        List<WareHouse> warehouses=new ArrayList<>();
        warehouses.add(wareHouse);

        ProductDelieverySystem productDelieverySystem=new ProductDelieverySystem(users,warehouses);
        productDelieverySystem.addProductToCart(user,productCategory,1);
        Order order =productDelieverySystem.placeOrder(user,wareHouse);
        productDelieverySystem.checkout(order);
        System.out.println(order.orderStatus);

    }
}
