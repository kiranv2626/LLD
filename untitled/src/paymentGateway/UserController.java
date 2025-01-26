package paymentGateway;

public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserDo addUser(UserDo userDo) {
        return userService.addUser(userDo);
    }

    public UserDo getUser(int userId) {
        return userService.getUser(userId);
    }

}
