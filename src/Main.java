/**
 * CONNECTING OUR CLASSES TOGETHER
 * - CREATE A USER FROM USER INPUT
 * - CREATE A ANIMAL DB
 * - USE COMMANDS TO INTERACT WITH CLASSES ^^^
 */


public class Main {
    public static void main(String[] args) {

        // INITIALISE THE CLASS
        // - GIVE IT THE DATA IT NEEDS
        Animal charlie = new Animal("Charlie", "Magpie", "animal-1");
//        System.out.println(charlie.getInfo());


//        Animal rob = new Animal("Rob", "Orca", "animal-2");

        Commands home = new Commands("Home",  new String[]{"Create user", "Create Animal", "Quit"});

        home.printMessage("Hello");
        home.printGreeting();
        home.printCommands();
        home.getIntegerInput();

    }
}