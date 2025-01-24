package template;

public class PaytoFriend extends Paymentflow{
    @Override
    public void verify() {
        System.out.println("verify to friend");
    }
    @Override
    public void credit() {
        System.out.println("credit to friend");
    }

    @Override
    public void debit() {
        System.out.println("debit to friend");
    }

    @Override
    public void deductServiceCharge() {
        System.out.println("deduct service charges to friend");
    }

}
