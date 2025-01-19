package splitwise;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User> userList;
    UserController() {
        this.userList = new ArrayList<>();
    }

    public void addUser(User user) {
        this.userList.add(user);
    }

    public List<User> getUserList() {
        return this.userList;
    }

    public void removeUser(User user) {
        this.userList.remove(user);
    }

    public User getUser(String userId) {
        for (User user : this.userList) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }
}
