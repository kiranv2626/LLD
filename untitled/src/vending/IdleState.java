package vending;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {
    public IdleState(){
        System.out.println("Idle State");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Idle State");
        machine.setCoins(new ArrayList<>());
    }
    @Override
    public void pressInsertCoin(VendingMachine machine) throws Exception {
        System.out.println("Insert Coin State needs to be set");
        machine.setState(new HasMoneyState());
    }

    @Override
    public void pressSelectProduct(VendingMachine machine) throws Exception {
        throw new Exception("First Seclect Insert Coin");
    }

    @Override
    public List<Coin> fullRefund(VendingMachine machine) throws Exception {
        throw new Exception("First Seclect Insert Coin");
    }

    @Override
    public int returnChange(int changeMoney) throws Exception {
        throw new Exception("First Seclect Insert Coin");
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
        throw new Exception("First Seclect Insert Coin");
    }

    @Override
    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("First Seclect Insert Coin");
    }

}
