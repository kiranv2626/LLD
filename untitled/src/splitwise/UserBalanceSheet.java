package splitwise;

import java.util.HashMap;

public class UserBalanceSheet {
    HashMap<String,Balance> balancesheet;
    double totalPayment;
    double totalExpense;
    double totalOwe;
    double totalGetBack;

    public UserBalanceSheet() {
        balancesheet = new HashMap<>();
        totalPayment = 0.0;
        totalExpense = 0.0;
        totalOwe = 0.0;
        totalGetBack = 0.0;
    }

    public HashMap<String,Balance> getBalancesheet() {
        return balancesheet;
    }

    public void setBalancesheet(HashMap<String,Balance> balancesheet) {
        this.balancesheet = balancesheet;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(double totalOwe) {
        this.totalOwe = totalOwe;
    }

    public double getTotalGetBack() {
        return totalGetBack;
    }

    public void setTotalGetBack(double totalGetBack) {
        this.totalGetBack = totalGetBack;
    }
}
