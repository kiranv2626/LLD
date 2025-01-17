package vending;

import carrental.VehicleInventory;

import java.util.List;

public interface State {
    public void pressInsertCoin(VendingMachine machine) throws Exception;
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception;
    public void pressSelectProduct(VendingMachine machine) throws Exception;
    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception;
    public List<Coin> fullRefund(VendingMachine machine) throws Exception;
    public int returnChange(int changeMoney) throws Exception;
    public void dispenseItem(VendingMachine machine, int codeNumber) throws Exception;
    public void updateInventry(VendingMachine machine, Item item, int codeNumber) throws  Exception;

}
