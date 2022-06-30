public class HomeCommands extends Commands {
    public HomeCommands() {
        super("Home", new String[]{"Visit Animal", "Manage Animals","Animal Stats", "Quit" }, "home");
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
        } else if (userInput == 3) {
            setNextCommands("stats");
        }else {
            setNextCommands("");
        }
    }
}
