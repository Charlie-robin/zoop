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
            // PRINT OUT THE ANIMAL NAMES ONLY
            // YOU MAY NEED A GETTER?
        } else if (userInput == 2) {
            // GET ONLY TAME ANIMALS
            // PRINT OUT THE NUMBER OF TAME ANIMALS
            // PRINT THE TAME ANIMALS
        } else if (userInput == 3) {
            // GET THE ANIMAL WITH THE MIN HAPPINESS
            // PRINT OUT THE ANIMAL
        } else if(userInput == 4){
            // FIND OUT WHETHER THE USER WANTS TO VIEW BY LIONS OR MAGPIES
            // BASED ON WHAT THEY CHOOSE
            // PRINT OUT THE TOTAL NUMBER OF THAT ANIMAL TYPE
            // PRINT THE ANIMAL TYPE ANIMALS
        } else {
            setNextCommands("home");
        }

    }
}

