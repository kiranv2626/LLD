package inventory;

import java.util.Map;

public class WareHouse {
    Inventory inventory ;
    Address address;

    public WareHouse(Inventory inventory, Address address) {
        this.inventory = inventory;
        this.address = address;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void removeItemFromInventory(Map<Integer, Integer> prodctCategoryvsCount) {
        inventory.removeItem(prodctCategoryvsCount);
    }
    public void addProductToInventory(int CategoryId, Product product) {
        inventory.addProduct(CategoryId, product);
    }

    public void addItemstoCart(Map<Integer, Integer> prodctCategoryvsCount) {
        inventory.removeItem(prodctCategoryvsCount);
    }
}
