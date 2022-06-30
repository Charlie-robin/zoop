import java.util.ArrayList;
import java.util.List;

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

            for (Animal animal : Zoo.getZoo()) {
                printMessage(animal.toString());
            }

        } else if (userInput == 2) {
            printMessage("View Animals by happiness");

            Zoo.sortAnimals();

            for (Animal animal : Zoo.getZoo()) {
                printMessage(animal.toString());
            }


        } else if (userInput == 3){
            printMessage("Enter Search term:");
            String searchTerm = getStringInput();

            // WE NEED AWAY OF SEARCHING AN ANIMAL & USER
            // THESE ARE DIFFERENT CLASSES -> INTERFACE TO THE RESCUE
            // USING THE INTERFACE AS THE TYPE -> MAKE A LIST OF SEARCHABLE ITEMS
            // GET THE ANIMAL ARRAYLIST AND ADD ALL ANIMALS TO SEARCH
            List<Searchable> toSearch = new ArrayList<>(Zoo.getZoo());
            toSearch.add(user);

            for (Searchable searchItem: toSearch) {
                // WE USE THE METHOD ON THE INTERFACE -> hasMatch -> BOOLEAN
                if(searchItem.hasMatch(searchTerm)){
                    // WE USE THE METHOD ON THE INTERFACE -> toString -> STRING
                    printMessage(searchItem.toString());
                }
            }


        } else {
            setNextCommands("home");
        }




    }
}