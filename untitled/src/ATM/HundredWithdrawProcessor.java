package ATM;

public class HundredWithdrawProcessor extends WithDrawProcessor {
    public HundredWithdrawProcessor(WithDrawProcessor withDrawProcessor) {
        super(withDrawProcessor);
    }

    public void withdraw(ATM atm, int amount) {
        int required = amount / 100;
        int balance = amount % 100;
        if (required <= atm.getNoOf100Notes()) {
            atm.setNoOf500Notes(atm.getNoOf100Notes() - required);
        }
        else {

            balance=balance+(required-atm.getNoOf500Notes())*100;
            atm.setNoOf100Notes(0);
        }
        if(balance>0)
        {
           System.out.println("OOps something went wrong");
        }
    }
}
