package inventory;

import java.util.List;

public class ProductDelieverySystem {
    UserController userController ;
    OrderController orderController ;
    WarehouseController wareHouseController ;
    public ProductDelieverySystem(List<User> users, List<WareHouse> warehouses)
    {
        userController = new UserController(users);
        orderController = new OrderController();
        wareHouseController = new WarehouseController(warehouses,null);
    }

    public User getUser(int userId) {
        return userController.getUser(userId);
    }

    public WareHouse getWareHouse(WareHouseSelectionStartergy wareHouseSelectionStartergy) {
        return wareHouseController.selectWareHouse(wareHouseSelectionStartergy);
    }

    public void addProductToCart(User user,ProductCategory productCategory,int count) {
        Cart cart= user.getCart();
        cart.addItem(productCategory.getCategoryId(),count);
        WareHouse wareHouse = getWareHouse(new NearWareHouse());
        wareHouse.removeItemFromInventory(cart.getCartItems());


    }

    public Order placeOrder(User user,WareHouse WareHouse) {
        return orderController.createOrder(user,WareHouse);
    }

    public Order checkout(Order order) {
        order.checkout();
        return order;
    }

}
