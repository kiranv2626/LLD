package ATM;

import java.util.Date;

public class ATMRoom {
    ATM atm ;
    User user;

    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.atm = ATM.getInstance();
        atmRoom.user = new User();
        atmRoom.user.setBankAccount(new BankAccount());
        atmRoom.user.getBankAccount().setBalance(10000);
        atmRoom.user.getBankAccount().setFullName("John Doe");
        atmRoom.user.getBankAccount().setAccountNumber("123456789");
        atmRoom.user.setCard(new Card());
        atmRoom.user.getCard().setName("John Doe");
        atmRoom.user.getCard().setCardNumber(123456789);
        atmRoom.user.getCard().setPin(1234);
        atmRoom.user.getCard().setCvv(123);
        atmRoom.user.getCard().setExpiryDate(new Date(2022, 12, 31));
        atmRoom.user.getCard().setBankAccount(atmRoom.user.getBankAccount());

        atmRoom.atm.setBalance(10000,3,4,20);
        atmRoom.atm.getAtmState().insertCard(atmRoom.atm,atmRoom.user.getCard());
        atmRoom.atm.getAtmState().authenticatePin(atmRoom.atm,atmRoom.user.getCard(),1234);
        atmRoom.atm.getAtmState().selectOperation(atmRoom.atm,atmRoom.user.getCard(),TransactionType.WITHDRAW);
        atmRoom.atm.getAtmState().withdraw(atmRoom.atm,atmRoom.user.getCard(),5000);
        System.out.println(atmRoom.user.getBankAccount().getBalance());
        System.out.println(atmRoom.atm.getNoOf2000Notes());
        System.out.println(atmRoom.atm.getNoOf500Notes());
        System.out.println(atmRoom.atm.getNoOf100Notes());
//        atmRoom.atm.getAtmState().checkBalance(atmRoom.atm,atmRoom.user.getCard());
//        atmRoom.atm.getAtmState().exit(atmRoom.atm,atmRoom.user.getCard());
//        atmRoom.atm.getAtmState().returnCard(atmRoom.atm,atmRoom.user.getCard());
    }
}
