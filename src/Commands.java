import java.util.ArrayList;
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

public class Commands {
    private final Scanner scanner = new Scanner(System.in);
    // final -> will never change
    private final String name;
    private final String[] commands;

    public Commands(String name, String[] commands) {
        this.name = name;
        this.commands = commands;
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printGreeting(){
        printMessage("Welcome to the " + name + " commands.");
    }

    public void printCommands(String[] commands){
        for (int i = 0; i < commands.length; i++) {
            printMessage((i + 1) + " : " + commands[i]);
        }
    }

    // OVERLOAD printCommands
    // ONE METHOD SHOULD TAKE AN STRING[] AS A PARAMETER
    // - IT SHOULD LOOP THROUGH & KEEP THE ORIGINAL PRINT FUNCTIONALITY
    // ONE METHOD SHOULD HAVE NO PARAMETERS
    // - IT SHOULD PASS IN THE commands FIELD

// EXTENSION
// ADD ANOTHER printCommands THAT TAKES ArrayList<String>
// - IT SHOULD LOOP THROUGH & KEEP THE ORIGINAL PRINT FUNCTIONALITY

    public void printCommands(){
        printCommands(commands);
    }

    public void printCommands(ArrayList<String> commandsList){
        String[] commands = commandsList.toArray(new String[0]);
        printCommands( commands );
    }

    // OVERLOADED METHOD
    // TAKES A LIMIT AND WILL GET YOU A NUMBER BETWEEN 0 - LIMIT
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


    // OVERLOADED METHOD
    // CALLS THE METHOD ABOVE GIVE IT THE COMMANDS LENGTH -> WILL GET NUMBER 0 - COMMANDS LENGTH
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
