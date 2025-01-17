package ATM;

public class FiveHundredWithdrawProcessor extends WithDrawProcessor {
    public FiveHundredWithdrawProcessor(WithDrawProcessor withDrawProcessor){
        super(withDrawProcessor);
    }
    public void withdraw(ATM atm, int amount) {
        int required = amount / 500;
        int balance = amount % 500;
        if (required <= atm.getNoOf500Notes()) {
            atm.setNoOf500Notes(atm.getNoOf500Notes() - required);
        }
        else {

            balance=balance+(required-atm.getNoOf500Notes())*500;
            atm.setNoOf500Notes(0);
        }
        if(balance>0)
            super.withdraw(atm, balance);
    }
}
