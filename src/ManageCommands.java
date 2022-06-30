import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManageCommands extends Commands{

    private final User user;

    public ManageCommands(User user) {
        super("Manage", new String[]{"All Animal Info", "View Animals by happiness", "Search", "Back"}, "manage");
        this.user = user;
    }

    @Override
    public void run() {

        printGreeting();
        printCommands();

        int userInput = getIntegerInput();

        if (userInput == 1) {
            printMessage("All Animal Info");
            // PASS IN LAMBDA EXPRESSION
            // PARAMETER -> DO SOMETHING
            // (PARAMETER1, PARAMETER) -> DO SOMETHING
            // PARAMETER -> { RETURN SOMETHING }

            // PASSING IN LAMBDA EXPRESSION -> ACTION -> WHAT WE WANT TO HAPPEN
            Zoo.getZoo().forEach(animal -> printMessage(animal.toString()));

            // METHOD REFERENCE -> WE WILL COME BACK TO THAT

        } else if (userInput == 2) {
            printMessage("View Animals by happiness");

            Zoo.sortAnimals().forEach(animal -> printMessage(animal.toString()));

        } else if (userInput == 3){
            printMessage("Enter Search term:");
            String searchTerm = getStringInput();

            // WE NEED AWAY OF SEARCHING AN ANIMAL & USER
            // THESE ARE DIFFERENT CLASSES -> INTERFACE TO THE RESCUE
            // USING THE INTERFACE AS THE TYPE -> MAKE A LIST OF SEARCHABLE ITEMS
            // GET THE ANIMAL ARRAYLIST AND ADD ALL ANIMALS TO SEARCH
            List<Searchable> toSearch = new ArrayList<>(Zoo.getZoo());
            toSearch.add(user);

//            for (Searchable searchItem: toSearch) {
//                // WE USE THE METHOD ON THE INTERFACE -> hasMatch -> BOOLEAN
//                if(searchItem.hasMatch(searchTerm)){
//                    // WE USE THE METHOD ON THE INTERFACE -> toString -> STRING
//                    printMessage(searchItem.toString());
//                }
//            }

            List<String> searchResults = toSearch
                    .stream() // TURN INTO A STREAM -> ALLOWS US TO PREFORM ACTIONS
                    .filter(searchItem -> searchItem.hasMatch(searchTerm)) // FILTER BASED ON TRUE / FALSE
                    .map(Searchable::toString) // TAKE CLASS TURN INTO STRING
                    .collect(Collectors.toList());

            // METHOD REFERENCE VS LAMBDA EXPRESSION
            // .map(Searchable::toString) = .map(searchItem -> searchItem.toString())
            // searchResults.forEach(this::printMessage) = searchResults.forEach(result -> printMessage(result));

            printMessage(searchResults.size() + " result(s) found.");
            searchResults.forEach(this::printMessage);
        } else {
            setNextCommands("home");
        }
    }
}