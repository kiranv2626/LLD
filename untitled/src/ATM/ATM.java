package ATM;

public class ATM {
    private static ATM atmObject=new ATM();
    ATMState atmState;;
    int atmBalance;
    int noOf2000Notes;
    int noOf500Notes;
    int noOf100Notes;

    private ATM() {}

    public static ATM getInstance() {
        atmObject.setAtmState(new IdleState());
        return atmObject;
    }

    public ATMState getAtmState() {

        return atmState;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }

    public int getNoOf2000Notes() {
        return noOf2000Notes;
    }

    public void setNoOf2000Notes(int noOf2000Notes) {
        this.noOf2000Notes = noOf2000Notes;
    }

    public int getNoOf500Notes() {
        return noOf500Notes;
    }

    public void setNoOf500Notes(int noOf500Notes) {
        this.noOf500Notes = noOf500Notes;
    }

    public int getNoOf100Notes() {
        return noOf100Notes;
    }

    public void setNoOf100Notes(int noOf100Notes) {
        this.noOf100Notes = noOf100Notes;
    }

    public void setBalance(int balance, int noOf2000Notes, int noOf500Notes, int noOf100Notes) {
        this.atmBalance = balance;
        this.noOf2000Notes = noOf2000Notes;
        this.noOf500Notes = noOf500Notes;
        this.noOf100Notes = noOf100Notes;
    }

    public void deductBalance(int amount) {
        this.atmBalance -= amount;
    }
}
