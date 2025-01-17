package ATM;

public class CheckBalanceState  extends ATMState {
    @Override
    public void checkBalance(ATM atm, Card card) {
        System.out.println("Balance: "+card.getBankAccount().getBalance());
        //exit(atm,card);
    }

    @Override
    public void exit(ATM atm, Card card) {
        returnCard(atm,card);
        atm.setAtmState(new IdleState());
        System.out.println("Use Exited");
    }

    @Override
    public void returnCard(ATM atm, Card card) {
        System.out.println("Card returned");
    }
}
