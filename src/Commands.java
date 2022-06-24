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

    public void printCommands(){
        for (int i = 0; i < commands.length; i++) {
            printMessage((i + 1) + " : " + commands[i]);
        }
    }
    public int getIntegerInput(){

        int input = 0;
        boolean isActive = true;

        while(isActive){
        printMessage("Enter a number between 1 - " + commands.length);
        int userInput = scanner.nextInt();

        if(userInput > 0 && userInput <= commands.length){
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

    /*
     * WRITE A METHOD CALLED getStringInput
     * - IT SHOULD RETURN A STRING
     * - DISPLAY THIS MESSAGE "Enter text"
     * - USE THE SCANNER TO CAPTURE THE USERS INPUT
     * - IF THE USER HAS ENTERED A VALUE RETURN IT
     * - IF THE USER HASN'T ENTERED ANYTHING
     *   - DISPLAY THIS MESSAGE "Unable to understand input, try again"
     *   - TRY TO GET THE INPUT AGAIN.
     */

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
