/**
 * FOCUSING ON INHERITANCE
 *
 * MAGPIE CLASS GAINS ALL FIELDS AND METHODS FROM ANIMAL CLASS
 * - GIVES THE ANIMAL CONSTRUCTOR THE DATA IT NEEDS
 * - STORES & GETS WHETHER IT IS FLYING OR NOT
 */

// INHERIT FROM THE ANIMAL CLASS -> GET ALL METHODS & PROPERTIES
public class Magpie extends Animal {
    private boolean isFlying;

    public Magpie(String name, String id) {
        // SUPER -> PASS THE INFORMATION THAT THE ANIMAL CLASS NEEDS
        super(name, "magpie", id , "Caaaarrrrrwwwww");
        this.isFlying = false;
    }

    public boolean isFlying() {
        return isFlying;
    }


    // POLYMORPHISM
    // - OVERRIDING IMPLEMENTATIONS OF METHODS
    // - ACTS THE SAME AS THE CLASS IT EXTENDS BUT CAN HAVE A DIFFERENT IMPLEMENTATION
    @Override
    public void receiveTreat( ) {
        // RECEIVE TREAT -> OVERRIDE IT
        // - IF THE ANIMAL IS FLYING YOU DON'T GIVE IT A TREAT & STOPS FLYING
        // - IF IT IS NOT FLYING YOU CAN GIVE IT A TREAT & STARTS FLYING
        if(isFlying){
            isFlying = false;
        } else {
            super.receiveTreat();
            isFlying = true;
        }
    }

    @Override
    public String toString() {
        // IF WE WANT TO USE THE ORIGINAL METHOD -> super.toString();
        // super -> THE PREVIOUS IMPLEMENTATION
        // WE CAN ADD ON ANY EXTRA INFO WE NEED

        return super.toString() + "\nisFlying : " + isFlying;
    }
}
