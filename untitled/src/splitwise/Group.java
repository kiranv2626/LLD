package splitwise;

import Calculator.Expression;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String groupId;
    String groupName;
    String groupDescription;
    List<User> userList;
    List<Expense> expenseList;
    ExpenseController expenseController;
    public Group(String groupId, String groupName, String groupDescription) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.userList = new ArrayList<>();
        this.expenseList = new ArrayList<>();
        this.expenseController = new ExpenseController();
    }
    public void addUser(User user){
        userList.add(user);
    }
    public void addExpense(Expense expense){
        expenseList.add(expense);
    }
    public void deleteExpense(Expense expense){
        expenseList.remove(expense);
    }
    public void removeUser(User user){
        userList.remove(user);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public ExpenseController getExpenseController() {
        return expenseController;
    }

    public void setExpenseController(ExpenseController expenseController) {
        this.expenseController = expenseController;
    }

    public Expense createExpense(String expenseId, String expenseName, String expenseDescription, double expenseAmount, User paidUser, SplitType splitType, List<Split> splitList) {
        Expense expense = expenseController.createExpense(expenseId, expenseName, expenseDescription, expenseAmount, paidUser, splitType, splitList);
        expenseList.add(expense);
        return expense;
    }
}
