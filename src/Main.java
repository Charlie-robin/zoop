
/**
 * CONNECTING OUR CLASSES TOGETHER
 * - CREATE A USER FROM USER INPUT
 * - CREATE A ANIMAL DB
 * - USE COMMANDS TO INTERACT WITH CLASSES ^^^
 */


public class Main {
    public static void main(String[] args) {

        // GETTING INFORMATION TO CREATE A USER
        UserCommands userCommands = new UserCommands();
        userCommands.run();

        // CREATING A USER
       User user = userCommands.getUser();

       Commands currentCommands = userCommands;

       // SETTING UP FIRST COMMANDS TO SHOW
       boolean isActive = true;
       // RUNNING THE APP
       while(isActive){
           switch(currentCommands.getNextCommands()){
               case "home" :
                   currentCommands = new HomeCommands();
                   currentCommands.run();
                   break;

               case "visit" :
                   currentCommands = new VisitCommands(user);
                   currentCommands.run();
                   break;

               case "manage" :
                   currentCommands = new ManageCommands();
                   currentCommands.run();
                   break;

               default:
                   isActive = false;
           }



       }


    }
}