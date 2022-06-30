import java.util.Scanner;

/**
 * ABSTRACTION
 *
 * COMMANDS CLASS RESPONSIBLE FOR:
 * - STORING THE NAME OF CURRENT COMMANDS
 * - STORING AN ARRAY OF GIVEN COMMANDS
 * - STORING A SCANNER
 * - PRINTING A MESSAGE
 * - PRINTING A GREETING FROM CURRENT SCREEN
 * - PRINTING INDEXED GIVEN COMMANDS
 * - GET INTEGER INPUT ENTERED BY USER
 * - GET STRING INPUT ENTERED BY USER
 */

public abstract class Commands {
    private final Scanner scanner = new Scanner(System.in);
    private final String name;
    private final String[] commands;
    private String nextCommands;
    public Commands(String name, String[] commands, String nextCommands) {
        this.name = name;
        this.commands = commands;
        this.nextCommands = nextCommands;
    }

    abstract public void run();

    public String getNextCommands() {
        return nextCommands;
    }

    public void setNextCommands(String nextCommands) {
        this.nextCommands = nextCommands;
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printGreeting(){
        printMessage("Welcome to the " + name + " commands.");
    }

    public void printCommands(){
        printCommands(commands);
    }

    public void printCommands(String[] commands){
        for (int i = 0; i < commands.length; i++) {
            printMessage((i + 1) + " : " + commands[i]);
        }
    }

    public int getIntegerInput(int rangeLimit){

        int input = 0;
        boolean isActive = true;

        while(isActive){
        printMessage("Enter a number between 1 - " + rangeLimit);
        int userInput = scanner.nextInt();

        if(userInput > 0 && userInput <= rangeLimit){
            isActive = false;
            input = userInput;
        } else {
            printMessage("Unable to understand input, try again");
        }
        }

        // TALKING POINT AND SHOW WHAT WILL HAPPEN IF YOU DON'T
        scanner.nextLine();

        return input;
    }

    public int getIntegerInput(){
        return getIntegerInput(commands.length);
    }

    public String getStringInput() {

        boolean isActive = true;

        String input = "";

        while (isActive) {
            printMessage("Enter text below:");
            String userInput = scanner.nextLine();

            if (!userInput.equals("")) {
                input = userInput;
                isActive = false;
            } else {
                printMessage("Unable to understand input, try again");
            }
        }

        return input;
    }

}
