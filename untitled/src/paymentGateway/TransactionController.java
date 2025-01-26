package paymentGateway;

import java.util.List;

public class TransactionController {
    TransactionService Service;

    public TransactionController(TransactionService Service) {
        this.Service = Service;
    }

    public void makePayment(TransactionDo transactionDo){
        Service.makePayment(transactionDo);
    }

    public List<Transaction> getTransactionHistory(int userId)
    {
            return Service.getTransactionHistory(userId);
    }
}
