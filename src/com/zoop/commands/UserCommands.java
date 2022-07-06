package com.zoop.commands;

import com.zoop.user.User;

public class UserCommands extends Commands {

    private User user;

    public UserCommands() {
        super("Create user", new String[]{}, CommandTypes.USER);
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

       setNextCommands(CommandTypes.START);

    }
}
