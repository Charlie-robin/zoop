
// INHERITANCE
public class UserCommands extends Commands {

    private User user;

    public UserCommands() {
        super("Create user", new String[]{}, "user");
    }

    public User getUser() {
        return user;
    }

    // PUTTING ALL THE LOGIC INTO THIS RUN METHOD -> ABSTRACTION
    @Override
    public void run() {
        printGreeting();
        printMessage("Enter  Username");
        String name = getStringInput();

        // CREATING A USER -> STORING IT AS A FIELD -> WITH GETTER
        user = new User(name);
        printMessage(user.toString());

       setNextCommands("home");

    }
}
