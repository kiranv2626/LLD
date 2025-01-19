package splitwise;

public class User {
    String userName;
    String userId;
    UserBalanceSheet userBalanceSheet;
    public User(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
        this.userBalanceSheet = new UserBalanceSheet();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserBalanceSheet getUserBalanceSheet() {
        return userBalanceSheet;
    }

    public void setUserBalanceSheet(UserBalanceSheet userBalanceSheet) {
        this.userBalanceSheet = userBalanceSheet;
    }
}
