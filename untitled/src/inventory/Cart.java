package inventory;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    HashMap<Integer, Integer> CategoryIdvsCount ;
    public Cart() {
        CategoryIdvsCount = new HashMap<Integer, Integer>();
    }

    public void addItem(int CategoryId, int count) {
        if(CategoryIdvsCount.containsKey(CategoryId)) {
            CategoryIdvsCount.put(CategoryId, CategoryIdvsCount.get(CategoryId) + count);
        } else {
            CategoryIdvsCount.put(CategoryId, count);
        }
    }

    public void removeItem(int CategoryId, int count) {
        if(CategoryIdvsCount.containsKey(CategoryId)) {
            if(CategoryIdvsCount.get(CategoryId) - count <= 0) {
                CategoryIdvsCount.remove(CategoryId);
            }
            else
            CategoryIdvsCount.put(CategoryId, CategoryIdvsCount.get(CategoryId) - count);
        }
    }

    public void emptyCart() {
        CategoryIdvsCount= new HashMap<Integer, Integer>();
    }

    public Map<Integer, Integer> getCartItems()
    {
        return CategoryIdvsCount;
    }
}
