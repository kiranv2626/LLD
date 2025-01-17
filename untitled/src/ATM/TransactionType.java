package ATM;

public enum TransactionType {
    WITHDRAW,
    BALANCE;

    public static void display() {
        for (TransactionType transactionType : TransactionType.values()) {
            System.out.println(transactionType);
        }
    }
}


