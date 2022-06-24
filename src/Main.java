/**
 * CONNECTING OUR CLASSES TOGETHER
 * - CREATE A USER FROM USER INPUT
 * - CREATE A ANIMAL DB
 * - USE COMMANDS TO INTERACT WITH CLASSES ^^^
 */


public class Main {
    public static void main(String[] args) {

        // INHERITANCE
        Magpie magpie = new Magpie("Maggy", "m-1");

        // POLYMORPHISM
        System.out.println(magpie.toString());
        magpie.receiveTreat(); // isFlying false
        System.out.println(magpie.toString());
        magpie.receiveTreat(); // isFlying true
        System.out.println(magpie.toString());


        // GETTING INFORMATION TO CREATE A USER
       Commands currentCommands = new Commands("Create user", new String[]{});
       currentCommands.printGreeting();
       currentCommands.printMessage("Enter  Username");
       String name = currentCommands.getStringInput();
        // CREATING A USER
       User user = new User(name);
       currentCommands.printMessage(user.toString());

       // SETTING UP FIRST COMMANDS TO SHOW
       String nextCommands = "home";
       boolean isActive = true;
    // RUNNING THE APP
       while(isActive){
           switch(nextCommands){
               case "home" :
                   currentCommands = new Commands("Home", new String[]{"Visit Animal", "Manage Animals", "Quit" });
                   currentCommands.printGreeting();
                   currentCommands.printCommands();
                   int userInput = currentCommands.getIntegerInput();

                   // FIGURING OUT WHICH SET OF COMMANDS TO RUN NEXT
                   if (userInput == 1) {
                       nextCommands = "visit";
                   } else if (userInput == 2) {
                       nextCommands = "manage";
                   } else {
                       nextCommands = "";
                   }

                   break;

               case "visit" :
                   currentCommands.printMessage("VISIT");
                   nextCommands = "home";
                   break;

               case "manage" :
                   currentCommands.printMessage("MANAGE");
                   nextCommands = "home";
                   break;

               default:
                   isActive = false;
           }



       }


    }
}