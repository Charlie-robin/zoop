/**
 * CONNECTING OUR CLASSES TOGETHER
 * - CREATE A USER FROM USER INPUT
 * - CREATE A ANIMAL DB
 * - USE COMMANDS TO INTERACT WITH CLASSES ^^^
 */


public class Main {
    public static void main(String[] args) {
        Animal charlie = new Animal("Charlie", "Magpie", "animal-1");
        Commands home = new Commands("Home",  new String[]{"Create user", "Create Animal", "Quit"});

        home.printMessage("Hello");
        home.printGreeting();
        home.printCommands();
        home.getIntegerInput();

    }
}