package vending;

import java.util.ArrayList;
import java.util.List;

public class SelectProductState implements State {
    public SelectProductState() {
        System.out.println("Select Product State");
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
    public List<Coin> fullRefund(VendingMachine machine) throws Exception {
        List<Coin> change = machine.getCoins();
        machine.setState(new IdleState());
        machine.setCoins(new ArrayList<>());
        System.out.println("Full Refund");
        return change;
    }



    @Override
    public void dispenseItem(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("This sttae already passed");
    }

    @Override
    public void updateInventry(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("This sttae already passed");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("This sttae already passed");
    }

    @Override
    public void selectProduct(VendingMachine machine, int codeNumber) throws Exception {
      List<Item> items = machine.getInventory().getItem(codeNumber);

      if(items.isEmpty()){
          throw new Exception("Item not available");
      }
      Item item = items.get(0);
      int price = item.getPrice();
      int paidByuser=0;
      List<Coin> coins = machine.getCoins();
      for(int i=0;i<coins.size();i++){
          paidByuser+=coins.get(i).value;
      }
      if(paidByuser<price){
          fullRefund(machine);
          throw new Exception("Insufficient amount");

      }
      System.out.println("Dispensing Item");
      machine.setState(new DispenseItemState());
      returnChange(paidByuser-price);
    }

    @Override
    public int returnChange(int changeMoney) throws Exception {
        System.out.println("Returning Change");
        return changeMoney;
    }

}
