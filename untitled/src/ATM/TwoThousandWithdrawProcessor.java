package ATM;

public class TwoThousandWithdrawProcessor extends WithDrawProcessor {
    TwoThousandWithdrawProcessor(WithDrawProcessor withDrawProcessor){
        super(withDrawProcessor);
    }

    public void withdraw(ATM atm, int amount) {
        int required = amount / 2000;
        int balance = amount % 2000;
        if (required <= atm.getNoOf2000Notes()) {
            atm.setNoOf2000Notes(atm.getNoOf2000Notes() - required);
        }
        else {

            balance=balance+(required-atm.getNoOf2000Notes())*2000;
            atm.setNoOf2000Notes(0);
        }
        if(balance>0)
            super.withdraw(atm, balance);
    }
}
