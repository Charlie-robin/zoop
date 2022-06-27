import java.util.ArrayList;
import java.util.List;

/**
 * CONNECTING OUR CLASSES TOGETHER
 * - CREATE A USER FROM USER INPUT
 * - CREATE A ANIMAL DB
 * - USE COMMANDS TO INTERACT WITH CLASSES ^^^
 */


public class Main {
    public static void main(String[] args) {
        List<Animal> zoo = new ArrayList<>();

        // OVERLOADED METHOD -> ArrayList.add()
        //  zoo.add(new Magpie("Maggy")); -> ADDED TO END
        //  zoo.add(new Magpie("Index zero", "magpie-1")); -> ADDED AT GIVEN INDEX

        // STATIC METHOD -> GET ANIMAL COUNT
        System.out.println(Animal.getAnimalCount()); // 0 -> BY DEFAULT 0

        // OVERLOADED CONSTRUCTORS
        zoo.add(new Magpie("Maggy")); // GIVE IT NAME ONLY IT HANDLES ID ETC..
        zoo.add(new Magpie("Rod", "r-1")); // GIVE IT NAME AND ID

        zoo.add(new Lion("Leroy","l-1"));

        // STATIC METHOD -> GET ANIMAL COUNT
        System.out.println(Animal.getAnimalCount()); // 3 -> INCREMENTS EACH TIME A ANIMAL IS CREATED


        System.out.println(zoo);

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

                   // OVERLOADED METHOD
                   // A NUMBER BETWEEN 0 - 3 -> 3 IS THE LENGTH OF THE COMMANDS ARRAY
                   int userInput = currentCommands.getIntegerInput();

                   // OVERLOADED METHOD
                   // PASS IN THE RANGE LIMIT -> EG A NUMBER BETWEEN 0 - 45
                   userInput = currentCommands.getIntegerInput(45);

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
                   currentCommands = new Commands("Visit", new String[]{"Pet Animal", "Give treat", "Go Back"});
                   Animal currentAnimal = zoo.get(0);

                   currentCommands.printGreeting();
                   // GET ANIMAL INFORMATION AND PRINT IT
                   currentCommands.printMessage(currentAnimal.toString());
                   currentCommands.printCommands();

                   userInput = currentCommands.getIntegerInput();

                   if (userInput == 1){
                       currentAnimal.pet();
                       user.incrementScore();
                   } else {
                       nextCommands = "home";
                   }


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