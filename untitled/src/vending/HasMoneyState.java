package vending;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HasMoneyState implements State {
    public HasMoneyState() {
        System.out.println("Has Money State");
    }
    @Override
    public void pressInsertCoin(VendingMachine machine) throws Exception {
        throw new Exception("This button is already pressed");
    }

    @Override
    public void pressSelectProduct(VendingMachine machine) throws Exception {
        System.out.println("Select Product State needs to be set");
        machine.setState(new SelectProductState());
    }

    @Override
    public List<Coin> fullRefund(VendingMachine machine) throws Exception {
        List<Coin> change = machine.getCoins();
        machine.setState(new IdleState());
        machine.setCoins(new ArrayList<>());
        System.out.println("Full Refund");
        return change;
    }

    @Override
    public int returnChange(int changeMoney) throws Exception {
        throw new Exception("No coins inserted");
    }

    @Override
    public void dispenseItem(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("First Seclect Insert Coin");
    }

    @Override
    public void updateInventry(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("First Seclect Insert Coin");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        System.out.println("Coin Inserted");
        machine.getCoins().add(coin);
    }

    @Override
    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("First Seclect Insert Coin");
    }
}
