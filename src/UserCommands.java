
public class UserCommands extends Commands {

    private User user;

    public UserCommands() {
        super("Create user", new String[]{}, "user");
    }

    public User getUser() {
        return user;
    }

    @Override
    public void run() {
        printGreeting();
        printMessage("Enter  Username");
        String name = getStringInput();
        user = new User(name);
        printMessage(user.toString());

       setNextCommands("home");

    }
}
