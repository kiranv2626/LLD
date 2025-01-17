package vending;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    ItemShelf [] inventory=null;

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public Inventory(int count) {
        this.inventory = new ItemShelf[count];
        intializeInventory();
    }

    private void intializeInventory() {
        int startCodeNumber=101;
        for(int i=0;i<inventory.length;i++){
            inventory[i] = new ItemShelf();
            inventory[i].setCodeNumber(startCodeNumber++);
            inventory[i].setAvailable(true);
            List<Item> coke = new ArrayList<>();
            List<Item> pepsi = new ArrayList<>();
            List<Item> soda = new ArrayList<>();
            List<Item> water = new ArrayList<>();
            List<Item> juice = new ArrayList<>();
            if(i==0) {
                for(int j=0;j<3;j++) {


                    Item item = new Item();
                    item.setItemType(ItemType.COKE);
                    item.setPrice(10);
                     coke.add(item);
                }
                inventory[i].setItem(coke);
            }
            else if(i==1) {
                for(int j=0;j<3;j++) {


                    Item item = new Item();
                    item.setItemType(ItemType.PEPSI);
                    item.setPrice(10);
                    pepsi.add(item);
                }
            }
            else if(i==2) {
                for(int j=0;j<3;j++) {
                    Item item = new Item();
                    item.setItemType(ItemType.SODA);
                    item.setPrice(10);
                    soda.add(item);
                }
                inventory[i].setItem(soda);
            }
            else if(i==3) {
                for (int j = 0; j < 3; j++) {
                Item item = new Item();
                item.setItemType(ItemType.WATER);
                item.setPrice(10);
                water.add(item);
                }
                inventory[i].setItem(water);
            }
            else if(i==4) {
                for (int j = 0; j < 3; j++){
                Item item = new Item();
                item.setItemType(ItemType.JUICE);
                item.setPrice(10);
                juice.add(item);
                }
                inventory[i].setItem(juice);
            }
        }
    }

    public void addItem(Item item, int codeNumber) {
        for(int i=0;i<inventory.length;i++){
            if(inventory[i].getCodeNumber()==codeNumber){
                inventory[i].getItem().add(item);
                if(inventory[i].getItem().size()>0)
                inventory[i].setAvailable(true);
                break;
            }
        }
    }

    public List<Item>  getItem(int codeNumber) {
        List<Item> items1 =new ArrayList<>();
        for(int i=0;i<inventory.length;i++){
            if(inventory[i].getCodeNumber()==codeNumber){
                items1 = inventory[i].getItem();
                break;
            }
        }
        return items1;
    }

}
