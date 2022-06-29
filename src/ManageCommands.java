
public class ManageCommands extends Commands{


    public ManageCommands() {
        super("Manage", new String[]{"All Animal Info", "View Animals by happiness", "Search", "Back"}, "manage");

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
            printMessage("Search");
        } else {
            setNextCommands("home");
        }




    }
}