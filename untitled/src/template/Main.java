package template;

public class Main {

    public static void main(String[] args) {
        PaytoMerchant paytoMerchant = new PaytoMerchant();
        paytoMerchant.sendMoney();
        PaytoFriend paytoFriend = new PaytoFriend();
        paytoFriend.sendMoney();
    }
}
