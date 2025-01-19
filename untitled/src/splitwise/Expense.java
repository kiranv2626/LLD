package splitwise;

import Calculator.Expression;
import stratergy.SportsStratergy;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String expenseId;
    String expenseName;
    String expenseDescription;
    double expenseAmount;
    User paidUser;
    SplitType splitType;
    List<Split> splitList=new ArrayList<>();
    public Expense(String expenseId, String expenseName, String expenseDescription, double expenseAmount, User paidUser, SplitType splitType, List<Split> splitList) {
        this.expenseId = expenseId;
        this.expenseName = expenseName;
        this.expenseDescription = expenseDescription;
        this.expenseAmount = expenseAmount;
        this.paidUser = paidUser;
        this.splitType = splitType;
        this.splitList.addAll(splitList);
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public User getPaidUser() {
        return paidUser;
    }

    public void setPaidUser(User paidUser) {
        this.paidUser = paidUser;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

    public void setSplitList(List<Split> splitList) {
        this.splitList = splitList;
    }
}
