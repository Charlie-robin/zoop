package com.zoop.commands;

import com.zoop.animals.Animal;
import com.zoop.animals.AnimalTypes;
import com.zoop.zoo.Zoo;

import java.util.List;
import java.util.stream.Collectors;

public class StatsCommands extends Commands {
    public StatsCommands() {
        super("Stats", new String[]{"Print Animal Name's","Print Tame animals", "Print Least happy", "By type", "Back" }, CommandTypes.STATS);
    }

    @Override
    public void run() {
        printGreeting();
        printCommands();
        int userInput = getIntegerInput();


        if (userInput == 1) {

            Zoo.getZoo()
                    .stream()
                    .map(Animal::getName)
                    .forEach(this::printMessage);

        } else if (userInput == 2) {

            List<String> tameAnimals = Zoo.getZoo()
                    .stream()
                    .filter(Animal::getIsTame)
                    .map(Animal::toString)
                    .collect(Collectors.toList());

            printMessage(tameAnimals.size() + " tame animal(s)");
            tameAnimals.forEach(this::printMessage);

        } else if (userInput == 3) {

            // MIN
            // Optional<com.zoop.animals.Animal> leastHappyAnimal = com.zoop.zoo.Zoo.getZoo()
            //       .stream()
            //        .min((a, b) -> a.getHappiness() - b.getHappiness());
            // leastHappyAnimal.ifPresent(animal -> printMessage(animal.toString()));

            // REDUCE
            Animal leastHappyAnimal = Zoo.getZoo()
                    .stream()
                    .reduce(Zoo.getAnimalByIndex(0), (accumulator, current) -> accumulator.getHappiness() < current.getHappiness() ? accumulator : current);

            printMessage(leastHappyAnimal.toString());

        } else if(userInput == 4){
            AnimalTypes[] animalTypes = {AnimalTypes.LION, AnimalTypes.MAGPIE};
            printCommands( new String[]{AnimalTypes.LION.toString(), AnimalTypes.MAGPIE.toString()});

            int userSelection = getIntegerInput(animalTypes.length);
            AnimalTypes selectedAnimal = animalTypes[userSelection - 1];

            List<String> animalByType = Zoo.getZoo()
                    .stream()
                    .filter(animal -> animal.getType().equals(selectedAnimal))
                    .map(Animal::toString)
                    .collect(Collectors.toList());

            printMessage(animalByType.size() + " " + selectedAnimal +"(s)");

            animalByType.forEach(this::printMessage);
        } else {
            setNextCommands(CommandTypes.START);
        }

    }
}

