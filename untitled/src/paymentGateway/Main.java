package paymentGateway;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserDo userDo = new UserDo();
        userDo.setUserId(1);
        userDo.setUserName("test");
        userDo.setEmail("test");
        UserService userService = new UserService();
        UserDo userDo1 = userService.addUser(userDo);
        System.out.println(userDo1);

        UserDo userDo2 = new UserDo();
        userDo2.setUserId(2);
        userDo2.setUserName("test1");
        userDo2.setEmail("test1");

        userService.addUser(userDo2);

        instrumentDo instrumentDo = new instrumentDo();
        instrumentDo.instrumentId=1;
        instrumentDo.userId=1;
        instrumentDo.cardNumber="123456789";
        instrumentDo.cvv=123;
        instrumentDo.instrumentType=InstrumentType.CREDIT_CARD;
        InstrumentService instrumentService=new CardInstrumentService();
        instrumentService.addInstrument(instrumentDo);

        instrumentDo instrumentDo2 = new instrumentDo();
        instrumentDo2.instrumentId=2;
        instrumentDo2.userId=2;
        instrumentDo2.bankAcountNumber="123456789";
        instrumentDo2.IFSCCode="123456789";
        instrumentDo2.instrumentType=InstrumentType.BANK;
        instrumentService.addInstrument(instrumentDo2);

        InstrumentController instrumentController=new InstrumentController(new InstrumentServiceFactory());
        List<instrumentDo> instrumentList=instrumentController.getInstrument(1);
        System.out.println(instrumentList);

        TransactionDo transactionDo=new TransactionDo();
        transactionDo.setTransactionId(1);
        transactionDo.setAmount(100);
        transactionDo.setSenderId(1);
        transactionDo.setRecieverId(2);
        transactionDo.setDebitInstrumentId(1);
        transactionDo.setCreditInstrumentId(2);
        transactionDo.setTransactionStatus(TransactionStatus.PENDING);

        TransactionService transactionService=new TransactionService();
        transactionService.makePayment(transactionDo);

         List<Transaction> transactionList=transactionService.getTransactionHistory(1);
         System.out.println(transactionList.get(0).amount);






    }
}
