package splitwise;

import java.util.List;
import java.util.Map;

public class BalanceController {
    public void updateBalancSheet(User paidUser, List<Split> splitList, double expenseAmount){
         UserBalanceSheet paidUserBalanceSheet=paidUser.getUserBalanceSheet();
         paidUserBalanceSheet.setTotalPayment(paidUserBalanceSheet.getTotalPayment() + expenseAmount);

         for(Split split:splitList){
             User oweUser=split.getUser();
             UserBalanceSheet owedUserBalanceSheet=oweUser.getUserBalanceSheet();
             double oweAmount=split.getAmount();
             if(oweUser.getUserId().equals(paidUser.getUserId())){
                 paidUserBalanceSheet.setTotalExpense(paidUserBalanceSheet.getTotalExpense() + oweAmount);

             }
             else
             {
                 //paiduser
                 Balance userOweBalance;
                 if(paidUserBalanceSheet.getBalancesheet().containsKey(oweUser.getUserId())){
                     userOweBalance=paidUserBalanceSheet.getBalancesheet().get(oweUser.getUserId());
                 }
                 else {
                     userOweBalance=new Balance();
                     paidUserBalanceSheet.getBalancesheet().put(oweUser.getUserId(),userOweBalance);
                 }
                 userOweBalance.setGetBackAmount(userOweBalance.getGetBackAmount() + oweAmount);
                 paidUserBalanceSheet.setTotalGetBack(paidUserBalanceSheet.getTotalGetBack() + oweAmount);

                 //oweduser
                 owedUserBalanceSheet.setTotalOwe(owedUserBalanceSheet.getTotalOwe() + oweAmount);
                 owedUserBalanceSheet.setTotalExpense(owedUserBalanceSheet.getTotalExpense() + oweAmount);
                 Balance getBackBalance;
                 if(owedUserBalanceSheet.getBalancesheet().containsKey(paidUser.getUserId())){
                     getBackBalance=owedUserBalanceSheet.getBalancesheet().get(paidUser.getUserId());
                 }
                 else {
                     getBackBalance=new Balance();
                     owedUserBalanceSheet.getBalancesheet().put(paidUser.getUserId(),getBackBalance);
                 }
                 getBackBalance.setOweAmount(getBackBalance.getOweAmount() + oweAmount);
             }

         }


    }

    public void showBalanceSheet(User user){
        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getUserId());

        UserBalanceSheet userBalanceSheet=user.getUserBalanceSheet();
        System.out.println("Total Payment : "+userBalanceSheet.getTotalPayment());
        System.out.println("Total GetBack : "+userBalanceSheet.getTotalGetBack());
        System.out.println("Total Owe : "+userBalanceSheet.getTotalOwe());
        System.out.println("Total Expense : "+userBalanceSheet.getTotalExpense());
        System.out.println("Balancesheet : ");
        for(Map.Entry<String,Balance> entry:userBalanceSheet.getBalancesheet().entrySet())
        {
            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userID:" + userID + " YouGetBack:" + balance.getGetBackAmount() + " YouOwe:" + balance.getOweAmount());

        }
        System.out.println("---------------------------------------");

    }
}
