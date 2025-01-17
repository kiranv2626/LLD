package ATM;

public class HasCardState extends ATMState {
    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {
        if (card.getPin() == pin) {
            atm.setAtmState(new SelectOperationState());
            System.out.println("Pin Authenticated");
        } else {
            System.out.println("Oops something went wrong");
        }
    }

    @Override
    public void exit(ATM atm, Card card) {
        returnCard(atm,card);
        atm.setAtmState(new IdleState());
        System.out.println("Use Exited");
    }

    @Override
    public void returnCard(ATM atm, Card card) {
        System.out.println("Card returned");
    }

}
