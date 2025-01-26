package paymentGateway;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    static List<User> users = new ArrayList<>();

    public UserDo addUser(UserDo userDo) {
        User user = new User();
        user.setUserId(userDo.getUserId());
        user.setUserName(userDo.getUserName());
        user.setEmail(userDo.getEmail());
        users.add(user);
        return convertUsertoUserDo(user);
    }
    public UserDo getUser(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return convertUsertoUserDo(user);
            }
        }
        return null;
    }
    private UserDo convertUsertoUserDo(User user) {
        UserDo userDo = new UserDo();
        userDo.setUserId(user.getUserId());
        userDo.setUserName(user.getUserName());
        userDo.setEmail(user.getEmail());
        return userDo;
    }
}
