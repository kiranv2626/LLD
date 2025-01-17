package ATM;

public class IdleState extends ATMState {
    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Insert card");
        atm.setAtmState(new HasCardState());
    }
}
