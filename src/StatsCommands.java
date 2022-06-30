import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

public class StatsCommands extends Commands {
    public StatsCommands() {
        super("Stats", new String[]{"Print Animal Name's","Print Tame animals", "Print Least happy", "By type", "Back" }, "stats");
    }

    @Override
    public void run() {
        printGreeting();
        printCommands();
        int userInput = getIntegerInput();

        // USE STREAMS -> STREAMS ONLY -> https://stackify.com/streams-guide-java-8/
        if (userInput == 1) {

            Zoo.getZoo()
                    .stream() // TURN INTO A STREAM
                    .map(Animal::getName) // GET ANIMAL NAMES
                    .forEach(this::printMessage); // PRINT EACH NAME OUT

        } else if (userInput == 2) {

            List<String> tameAnimals = Zoo.getZoo()
                    .stream() // TURN INTO A STREAM
                    .filter(Animal::getIsTame) // FILTER ON WHETHER ANIMAL IS TAME OR NOT
                    .map(Animal::toString) // GET ANIMAL NAMES
                    .collect(Collectors.toList()); // GET THE RESULT

            printMessage(tameAnimals.size() + " tame animal(s)"); // GET THE SIZE OF THE RESULT
            tameAnimals.forEach(this::printMessage); // PRINT THE RESULTS

        } else if (userInput == 3) {

            // MIN
            // Optional<Animal> leastHappyAnimal = Zoo.getZoo()
            //       .stream()
            //        .min((a, b) -> a.getHappiness() - b.getHappiness());
            // leastHappyAnimal.ifPresent(animal -> printMessage(animal.toString()));

            // REDUCE
            Animal leastHappyAnimal = Zoo.getZoo()
                    .stream()
                    .reduce(Zoo.getAnimalByIndex(0), (accumulator, current) -> accumulator.getHappiness() < current.getHappiness() ? accumulator : current);

            printMessage(leastHappyAnimal.toString());

        } else if(userInput == 4){
            String[] animalTypes = {"Lion", "Magpie"};
            printCommands(animalTypes);

            int userSelection = getIntegerInput(animalTypes.length);
            String selectedAnimal = animalTypes[userSelection - 1].toLowerCase(Locale.ROOT);

            List<String> animalByType = Zoo.getZoo()
                    .stream()
                    .filter(animal -> animal.getType().equals(selectedAnimal))
                    .map(Animal::toString)
                    .collect(Collectors.toList());

            printMessage(animalByType.size() + " " + selectedAnimal +"(s)");

            animalByType.forEach(this::printMessage);
        } else {
            setNextCommands("home");
        }

    }
}

