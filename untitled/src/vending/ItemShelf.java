package vending;

import java.util.HashMap;
import java.util.List;

public class ItemShelf {
    List<Item> item;
    int codeNumber;
    boolean isAvailable;
    HashMap<Integer,List<Item>> listHashMap;

    public HashMap<Integer, List<Item>> getListHashMap() {
        return listHashMap;
    }

    public void setListHashMap(HashMap<Integer, List<Item>> listHashMap) {
        this.listHashMap = listHashMap;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
    public void addItem(Item item, int codeNumber) {
        List<Item> items = listHashMap.get(codeNumber);
        items.add(item);
    }

    public List<Item> get(int codeNumber) {
        List<Item> items = listHashMap.get(codeNumber);
        return items;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }
}
