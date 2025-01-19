package splitwise;

import java.util.ArrayList;
import java.util.List;

public class SplitWise {
    UserController userController;
    GroupController groupController;
    ExpenseController expenseController;
    BalanceController balanceController;

    public SplitWise() {
        userController = new UserController();
        groupController = new GroupController();
        expenseController = new ExpenseController();
        balanceController = new BalanceController();
    }

    public void demo()
    {
        User user1 = new User("1", "user1");
        User user2 = new User("2", "user2");
        User user3 = new User("3", "user3");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);

        groupController.addGroup("1", "group1", "group1 description", user1);
        groupController.getGroup("1").addUser(user2);
        groupController.getGroup("1").addUser(user3);

        List<Split> splitList = new ArrayList<>();
        splitList.add(new Split(user1, 30));
        splitList.add(new Split(user2, 30));
        splitList.add(new Split(user3, 30));

        Expense expense = groupController.getGroup("1").createExpense("1", "expense1", "expense1 description", 100, user1, SplitType.EQUAL, splitList);

        balanceController.showBalanceSheet(user1);



    }

}
