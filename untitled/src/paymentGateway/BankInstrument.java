package paymentGateway;

public class BankInstrument extends Instrument {
    String bankAcountNumber;
    String IFSCCode;

    public String getBankAcountNumber() {
        return bankAcountNumber;
    }

    public void setBankAcountNumber(String bankAcountNumber) {
        this.bankAcountNumber = bankAcountNumber;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }
}
