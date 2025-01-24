package template;

public class PaytoMerchant extends Paymentflow{
    @Override
    public void verify() {
        System.out.println("Verifying Payment");
    }
    @Override
    public void debit() {
        System.out.println("Debiting Payment");
    }
    @Override
    public void credit() {
        System.out.println("Crediting Payment");
    }
    @Override
    public void deductServiceCharge() {
        System.out.println("Deducting Service Charge");
    }
}
