package ATM;

public class WithDrawProcessor {
    WithDrawProcessor nextProcessor;

    public WithDrawProcessor(WithDrawProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void withdraw(ATM atm, int amount) {
        if (nextProcessor != null) {
            nextProcessor.withdraw(atm, amount);
        }
    }
}
