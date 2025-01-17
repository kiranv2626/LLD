package ATM;

public class SelectOperationState extends ATMState{
    public SelectOperationState() {
        showOptions();
    }
    @Override
    public void selectOperation(ATM atm, Card card, TransactionType operation) {
        if(operation == TransactionType.WITHDRAW){
            atm.setAtmState(new WithdrawState());
        }else if(operation == TransactionType.BALANCE){
            atm.setAtmState(new CheckBalanceState());
        }
        else
        {
            System.out.println("Invalid Operation");
            exit(atm,card);
        }
    }

    public void showOptions() {
        TransactionType.display();
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
