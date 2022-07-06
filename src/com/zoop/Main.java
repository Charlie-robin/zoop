package com.zoop;

import com.zoop.commands.*;
import com.zoop.user.User;

/**
 * CONNECTING OUR CLASSES TOGETHER
 * - CREATE A USER FROM USER INPUT
 * - CREATE A ANIMAL DB
 * - USE COMMANDS TO INTERACT WITH CLASSES ^^^
 */


public class Main {
    public static void main(String[] args) {

        UserCommands userCommands = new UserCommands();
        userCommands.run();

       User user = userCommands.getUser();

       Commands currentCommands = userCommands;

       boolean isActive = true;

       while(isActive){
           switch(currentCommands.getNextCommands()){
               case START:
                   currentCommands = new HomeCommands();
                   break;

               case VISIT :
                   currentCommands = new VisitCommands(user);
                   break;

               case MANAGE :
                   currentCommands = new ManageCommands(user);
                   break;

               case STATS :
                   currentCommands = new StatsCommands();
                   break;

               default:
                   isActive = false;
           }

                  if(isActive){
                   currentCommands.run();
                  }
       }
    }
}