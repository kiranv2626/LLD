package inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {
    List<Order> orders;
    Map<Integer,List<Order>> userOrderMap;

    public OrderController() {
        this.orders = new ArrayList<>();
        this.userOrderMap = new HashMap<>();
    }

    public Order createOrder(User user,WareHouse wareHouse) {
        Order order = new Order(user,wareHouse);
        orders.add(order);
        if(userOrderMap.containsKey(user.userId))
        {
            List<Order> orderList=userOrderMap.get(user.userId);
            orderList.add(order);
            userOrderMap.put(user.userId,orderList);
        }
        else {
            List<Order> orderList=new ArrayList<>();
            orderList.add(order);
            userOrderMap.put(user.userId,orderList);
        }
        return order;
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        if(userOrderMap.containsKey(order.user.userId))
        {
            List<Order> orderList=userOrderMap.get(order.user.userId);
            orderList.remove(order);
            userOrderMap.put(order.user.userId,orderList);
        }
    }

    public List<Order> getUserOrders(int userId) {
        return userOrderMap.get(userId);
    }

    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }


}
