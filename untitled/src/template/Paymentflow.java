package template;

public abstract class Paymentflow {
    public abstract void verify();
    public abstract void debit();
    public abstract void deductServiceCharge();
    public abstract void credit();

    public final void sendMoney()
    {
        verify();
        debit();
        deductServiceCharge();
        credit();
    }

}
