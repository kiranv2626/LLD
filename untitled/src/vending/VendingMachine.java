package vending;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    Inventory inventory;
    State state;
    List<Coin> coins;

    public VendingMachine() {
        this.inventory = new Inventory(3);
        this.state = new IdleState();
        this.coins = new ArrayList<>();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }
}
