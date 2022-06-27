/**
 * FOCUSING ON INHERITANCE
 *
 * MAGPIE CLASS GAINS ALL FIELDS AND METHODS FROM ANIMAL CLASS
 * - GIVES THE ANIMAL CONSTRUCTOR THE DATA IT NEEDS
 * - STORES & GETS WHETHER IT IS FLYING OR NOT
 */

public class Magpie extends Animal {
    private boolean isFlying;

    public Magpie(String name) {
        super(name, "magpie","Caaaarrrrrwwwww");
        this.isFlying = false;
    }

    public Magpie(String name, String id) {
        super(name, "magpie",id,"Caaaarrrrrwwwww");
        this.isFlying = false;
    }

    public boolean isFlying() {
        return isFlying;
    }

    @Override
    public void receiveTreat( ) {

        if(isFlying){
            isFlying = false;
        } else {
            super.receiveTreat();
            isFlying = true;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nisFlying : " + isFlying;
    }
}
