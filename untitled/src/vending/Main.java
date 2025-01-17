package vending;

public class Main {
    public static void main(String[] args) {
        try {
            VendingMachine vendingMachine = new VendingMachine();
            vendingMachine.getState().pressInsertCoin(vendingMachine);
            vendingMachine.getState().insertCoin(vendingMachine, Coin.NICKEL);
            vendingMachine.getState().insertCoin(vendingMachine, Coin.DIME);
            vendingMachine.getState().insertCoin(vendingMachine, Coin.QUARTER);
            vendingMachine.getState().pressSelectProduct(vendingMachine);
            vendingMachine.getState().selectProduct(vendingMachine,101);
            vendingMachine.getState().dispenseItem(vendingMachine,101);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
