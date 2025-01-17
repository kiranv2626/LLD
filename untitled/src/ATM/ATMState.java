package ATM;

public abstract class ATMState {

    public void insertCard(ATM atm, Card card) {
        System.out.println("Oops something went wrong");
    }

    public void authenticatePin(ATM atm,Card card,int pin) {
        System.out.println("Oops something went wrong");
    }
    public void selectOperation(ATM atm,Card card,TransactionType operation) {
        System.out.println("Oops something went wrong");
    }
    public void withdraw(ATM atm,Card card,int amount) {
        System.out.println("Oops something went wrong");
    }
    public void checkBalance(ATM atm,Card card) {
        System.out.println("Oops something went wrong");
    }
    public void exit(ATM atm,Card card) {
        System.out.println("Oops something went wrong");
    }
    public void returnCard(ATM atm,Card card) {
        System.out.println("Oops something went wrong");
    }

}
