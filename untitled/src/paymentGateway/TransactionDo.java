package paymentGateway;

public class TransactionDo {
    int transactionId;
    int amount;
    int senderId;
    int recieverId;
    int debitInstrumentId;
    int creditInstrumentId;
    TransactionStatus transactionStatus;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(int recieverId) {
        this.recieverId = recieverId;
    }

    public int getDebitInstrumentId() {
        return debitInstrumentId;
    }

    public void setDebitInstrumentId(int debitInstrumentId) {
        this.debitInstrumentId = debitInstrumentId;
    }

    public int getCreditInstrumentId() {
        return creditInstrumentId;
    }

    public void setCreditInstrumentId(int creditInstrumentId) {
        this.creditInstrumentId = creditInstrumentId;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
