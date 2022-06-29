public class HomeCommands extends Commands {
    public HomeCommands() {
        super("Home", new String[]{"Visit Animal", "Manage Animals", "Quit" }, "home");
    }

    @Override
    public void run() {
        printGreeting();
        printCommands();

        int userInput = getIntegerInput();

        if (userInput == 1) {
            setNextCommands("visit");
        } else if (userInput == 2) {
            setNextCommands("manage");
        } else {
            setNextCommands("");
        }
    }
}
