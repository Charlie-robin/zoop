/**
 * CLASS SYNTAX CHALLENGE
 * CREATE A USER CLASS FIELDS, GETTERS AND SETTERS
 *
 * USER CLASS RESPONSIBLE FOR
 * - STORING & GETTING NAME
 * - STORING & GETTING & SETTING SCORE
 *   - SCORE SHOULD BE 0 ON INITIALIZATION
 *   - SCORE CAN NOT GO BELOW 0 OR OVER 100
 * - STORING & GETTING & SETTING TREAT COUNT
 *  - TREAT COUNT SHOULD BE 5 ON INITIALIZATION
 *  - TREAT COUNT CAN NOT GO BELOW 0 OR OVER 10
 *
 */

public class User {
    private final String name;
    private int treatCount;
    private int score;

    public User(String name) {
        this.name = name;
        this.score = 0;
        this.treatCount = 2;
    }

    public String getName() {
        return name;
    }

    public int getTreatCount() {
        return treatCount;
    }

    public void setTreatCount(int treatCount) {
        if (treatCount > 0 && treatCount <= 10) {
            this.treatCount = treatCount;
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (score > 0 && score <= 100) {
            this.score = score;
        }
    }

    public boolean hasTreatsLeft() {
        return treatCount > 0;
    }

    public void decrementTreats(){
        if (hasTreatsLeft()){
            setTreatCount(treatCount - 1);
        }
    }

    @Override
    public String toString(){
        return String.format("\nName : %s \nScore : %d \nTreat Count : %d\n",name,score, treatCount );
    }

    public void incrementScore(){

        setScore(score + 10);

        if(Math.random() <= .25){
            setTreatCount(treatCount + 1);
        }
    }


}
