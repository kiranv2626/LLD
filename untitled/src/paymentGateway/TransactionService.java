package paymentGateway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {
    InstrumentController instrumentController;
    static Map<Integer, List<Transaction>> userVsTransaction=new HashMap<Integer,List<Transaction>>();
    Processor processObj;
    public TransactionService()
    {
        instrumentController=new InstrumentController(new InstrumentServiceFactory());
        processObj=new Processor();
    }
    public void makePayment(TransactionDo transactionDo){
        instrumentDo send=instrumentController.getInstrumentById(transactionDo.getSenderId(),transactionDo.getDebitInstrumentId());
        instrumentDo recieve=instrumentController.getInstrumentById(transactionDo.getRecieverId(),transactionDo.getCreditInstrumentId());
        System.out.println("validating Instrument");
        processObj.process();
        System.out.println("Payment Done");

        Transaction transaction=new Transaction();
        transaction.setAmount(transactionDo.getAmount());
        transaction.setCreditInstrumentId(transactionDo.getCreditInstrumentId());
        transaction.setDebitInstrumentId(transactionDo.getDebitInstrumentId());
        transaction.setRecieverId(transactionDo.getRecieverId());
        transaction.setSenderId(transactionDo.getSenderId());
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setTransactionId(transactionDo.getTransactionId());

        List<Transaction> transactions= userVsTransaction.get(transactionDo.getSenderId());
        if(transactions==null)
        {
            transactions=new ArrayList<Transaction>();
        }
        transactions.add(transaction);
        userVsTransaction.put(transactionDo.getSenderId(),transactions);

        List<Transaction> transactionList=userVsTransaction.get(transactionDo.getRecieverId());
        if(transactionList==null)
        {
            transactionList=new ArrayList<Transaction>();
        }
        transactionList.add(transaction);
        userVsTransaction.put(transactionDo.getRecieverId(),transactionList);
    }

    public List<Transaction> getTransactionHistory(int userId) { return userVsTransaction.get(userId); }
}
