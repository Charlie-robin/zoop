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
    // ADD FIELDS TO A OBJECT
    // ACCESS-MODIFIER TYPE FIELD-NAME
    // PRIVATE -> CAN'T BE ACCESSED / MODIFIED
    private String name;
    private String type;

    private String id;

    private boolean isTame;

    private int happiness;

    // CONSTRUCTOR
    // - TAKES VALUES AND ASSIGNS THEM TO FIELDS -> BUILDING THE OBJECT
    // - WHEN INITIALISED IT RUNS

    public Animal(String name, String type, String id){
        // this -> REFERS TO THE OBJECT
        this.name = name;
        this.type = type;
        this.id = id;
        this.happiness = (int) (Math.random() * 100 + 1); // CASTING
        // SET TO THE COMPARISON BELOW BY DEFAULT
        this.isTame = this.happiness > 50;

    }

    // GETTER -> METHOD
    // - TO GET PRIVATE INFORMATION
    // - UNABLE TO BE CHANGED
    public String getId() {
        return id;
    }

    public boolean getIsTame(){
        return isTame;
    }

    //  SETTER -> METHOD
    // - TO CHANGE PRIVATE INFORMATION
    public void setIsTame(boolean tame){
        // CHANGE FIELD TO THE VALUE THAT GETS PASSED IN
        this.isTame = tame;
    }

    public int getHappiness() {
        return happiness;
    }

//     HAPPINESS CANNOT GO ABOVE 100
//     IF HAPPINESS GOES ABOVE 50 THE ANIMAL IS TAME
    public void setHappiness(int happiness) {
        if(happiness <= 100 && happiness > 0){
            this.happiness = happiness;
        }

        if(this.happiness > 50){
//            this.isTame = true;
            isTame = true;
        }
    }
}
