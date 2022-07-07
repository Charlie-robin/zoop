package com.zoop.commands;

import com.zoop.utils.Searchable;
import com.zoop.user.User;
import com.zoop.zoo.Zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManageCommands extends Commands {

    private final User user;

    public ManageCommands(User user) {
        super("Manage", new String[]{"All Animal Info", "View Animals by happiness", "Search", "Back"}, CommandTypes.MANAGE);
        this.user = user;
    }

    @Override
    public void run() {

        printGreeting();
        printCommands();

        int userInput = getIntegerInput();

        if (userInput == 1) {
            printMessage("All Animal Info");

            Zoo.getZoo().forEach(animal -> printMessage(animal.toString()));


        } else if (userInput == 2) {
            printMessage("View Animals by happiness");

            Zoo.sortAnimals().forEach(animal -> printMessage(animal.toString()));

        } else if (userInput == 3){
            printMessage("Enter Search term:");
            String searchTerm = getStringInput();

            List<Searchable> toSearch = new ArrayList<>(Zoo.getZoo());
            toSearch.add(user);


            List<String> searchResults = toSearch
                    .stream()
                    .filter(searchItem -> searchItem.hasMatch(searchTerm))
                    .map(Searchable::toString)
                    .collect(Collectors.toList());

            printMessage(searchResults.size() + " result(s) found.");
            searchResults.forEach(this::printMessage);
        } else {
            setNextCommands(CommandTypes.START);
        }
    }
}