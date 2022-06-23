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
        this.treatCount = 5;
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

    /**
     * USER METHODS CHALLENGE
     * ADD THE FOLLOWING METHODS
     *
     * - hasTreatsLeft()
     *  - CHECKS IF A USER HAS TREATS LEFT
     *  - RETURNS A BOOLEAN
     *
     * - decrementTreats()
     *  - IF A USER HAS TREATS LEFT DECREMENT THE TREAT COUNT
     *
     * - getInformation()
     *  - RETURNS A STRING IN THE FOLLOWING FORMAT
     *  - "\nName : NAME \nScore : SCORE \nTreat Count : TREAT COUNT\n"
     *  - THE CAPITAL LETTERS SHOULD BE REPLACED BY THE FIELDS IN THE CLASS
     *
     * - incrementScore()
     *  - INCREMENTS THE CURRENT SCORE BY 10
     *  - 1 IN 4 CHANCE TO GET A TREAT
     *  - DOES NOT RETURN ANYTHING
     */

    public boolean hasTreatsLeft() {
        return treatCount > 0;
    }

    public void decrementTreats(){
        if (hasTreatsLeft()){
            // treatCount-- check that
            setTreatCount(treatCount - 1);
        }
    }

    public String getInfo(){
        return String.format("\nName : %s \nScore : %d \nTreat Count : %d\n",name,score, treatCount );
    }

    public void incrementScore(){
        // this.score += 10
        setScore(score + 10);
        if((int) (Math.random() * 4) == 0){
            setTreatCount(treatCount + 1);
        }
//
//        if((int) (Math.random() * 100 + 1) < 25){
//            setTreatCount(treatCount + 1);
//        }
//
//         // 0 - 1
//        if(Math.random() <= .25){
//            setTreatCount(treatCount + 1);
//        }
    }


}
