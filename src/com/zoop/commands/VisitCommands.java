package com.zoop.commands;

import com.zoop.animals.Animal;
import com.zoop.user.User;
import com.zoop.zoo.Zoo;

public class VisitCommands extends Commands {
    public User user;

    public VisitCommands(User user) {
        super("Visit", new String[]{"Pet Animal", "Give treat", "Go Back"}, CommandTypes.VISIT);
        this.user = user;
    }

    @Override
    public void run() {
        Animal currentAnimal = Zoo.getAnimalByIndex(0);

        printGreeting();
        printMessage(currentAnimal.toString());
        printCommands();

        int userInput = getIntegerInput();

        if (userInput == 1){
            currentAnimal.pet();
            user.incrementScore();
        } else {
            setNextCommands(CommandTypes.START);
        }
    }
}
