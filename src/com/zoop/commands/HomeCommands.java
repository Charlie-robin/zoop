package com.zoop.commands;

public class HomeCommands extends Commands {
    public HomeCommands() {
        super("Home", new String[]{"Visit Animal", "Manage Animals","Animal Stats", "Quit" }, CommandTypes.HOME);
    }

    @Override
    public void run() {
        printGreeting();
        printCommands();

        int userInput = getIntegerInput();

        if (userInput == 1) {
            setNextCommands(CommandTypes.VISIT);
        } else if (userInput == 2) {
            setNextCommands(CommandTypes.MANAGE);
        } else if (userInput == 3) {
            setNextCommands(CommandTypes.STATS);
        }else {
            setNextCommands(CommandTypes.EXIT);
        }
    }
}
