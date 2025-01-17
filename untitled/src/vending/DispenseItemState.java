package vending;

import java.util.ArrayList;
import java.util.List;

public class DispenseItemState implements State{

    public DispenseItemState(){
        System.out.println("Dispensing Item");
    }

    @Override
    public void pressInsertCoin(VendingMachine machine) throws Exception {
        throw new Exception("This sttae already passed");
    }

    @Override
    public void pressSelectProduct(VendingMachine machine) throws Exception {
        throw new Exception("This sttae already passed");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("This sttae already passed");
    }

    @Override
    public void dispenseItem(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Item Dispensed");
        Item item = machine.getInventory().getItem(codeNumber).get(0);
        updateInventry(machine, item, codeNumber);
        machine.setState(new IdleState(machine));
        machine.setCoins(new ArrayList<>());
    }

    @Override
    public void updateInventry(VendingMachine machine, Item item, int codeNumber) throws Exception {
        System.out.println("Item Inventory Updated");
        machine.getInventory().getItem(codeNumber).remove(0);
    }

    @Override
    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("This sttae already passed");
    }

    @Override
    public List<Coin> fullRefund(VendingMachine machine) throws Exception {
        throw new Exception("This sttae already passed");
    }

    @Override
    public int returnChange(int changeMoney) throws Exception {
        throw new Exception("This sttae already passed");
    }


}
