package ATM;

public class WithdrawState extends ATMState {
    @Override
    public void withdraw(ATM atm, Card card, int amount) {
      if(amount > card.getBankAccount().getBalance()){
          System.out.println("Insufficient Balance");
          exit(atm,card);
      }
      else if(amount > atm.atmBalance){
          System.out.println("Insufficient ATM Balance");
          exit(atm,card);
      }
      else {
          atm.deductBalance(amount);
          card.deductAmount(amount);
          WithDrawProcessor withdrawProcessor = new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new HundredWithdrawProcessor(null)));
          withdrawProcessor.withdraw(atm,amount);
          System.out.println("Withdrawal successful");
          exit(atm,card);
      }


    }
    @Override
    public void returnCard(ATM atm, Card card) {
        System.out.println("Card returned");
    }
    @Override
    public void exit(ATM atm, Card card) {
        returnCard(atm,card);
        atm.setAtmState(new IdleState());
        System.out.println("Use Exited");
    }

}
