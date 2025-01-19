package splitwise;

import java.util.List;

public class ExpenseController {
    BalanceController balanceController ;
    ExpenseController(){
        balanceController=new BalanceController();
    }
    public Expense createExpense(String expenseId, String expenseName, String expenseDescription, double expenseAmount, User paidUser, SplitType splitType, List<Split> splitList) {
//        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
//        expenseSplit.validateSplitRequest(splitDetails, expenseAmount);
        Expense expense = new Expense(expenseId, expenseName, expenseDescription, expenseAmount, paidUser, splitType, splitList);
        balanceController.updateBalancSheet(paidUser, splitList, expenseAmount);
        return expense;
    }
}
