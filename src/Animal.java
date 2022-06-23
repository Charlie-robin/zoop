/**
 * FOCUSING ON CLASS SYNTAX
 *
 * ANIMAL CLASS RESPONSIBLE FOR:
 * - STORING NAME
 * - STORING TYPE
 * - STORING & GETTING ID
 * - STORING & GETTING & SETTING ISTAME
 * - STORING & GETTING & SETTING HAPPINESS
 *  - HAPPINESS CANNOT GO ABOVE 100
 *  - IF HAPPINESS GOES ABOVE 50 THE ANIMAL IS TAME
 * - PETTING THE ANIMAL
 * - GIVING THE ANIMAL A TREAT
 * - GETTING THE ANIMALS INFORMATION
 */

public class Animal {
    private String name;
    private String type;

    private String id;

    private boolean isTame;

    private int happiness;


    public Animal(String name, String type, String id){
        this.name = name;
        this.type = type;
        this.id = id;
        this.happiness = (int) (Math.random() * 100 + 1);
        this.isTame = this.happiness > 50;
    }

    public String getId() {
        return id;
    }

    public boolean getIsTame(){
        return isTame;
    }

    public void setIsTame(boolean tame){
        this.isTame = tame;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        if(happiness <= 100 && happiness > 0){
            this.happiness = happiness;
        }

        if(this.happiness > 50 && !isTame){
            isTame = true;
        }
    }

    public void pet(){setHappiness(Math.min(this.happiness + 10, 100));}

    public void receiveTreat(){
        setHappiness(Math.min(this.happiness + 30, 100));
    }


    public String getInfo(){
        return String.format("\nName :  %s\nType :  %s\nHappiness :  %d\nisTame :  %s",name, type, happiness, isTame );
    }


}
