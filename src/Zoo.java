import java.util.ArrayList;
import java.util.List;

/**
 * RESPONSIBLE FOR STORING & RETRIEVING ANIMALS
 * - WHAT IS A STATIC FIELD / METHOD?
 *  -  STATIC FIELD -> DOESN'T NEED TO BE INITIALISED -> EXISTS ON THE CLASS -> INDEPENDENT
 *  -  STATIC METHOD -> DOESN'T NEED TO BE INITIALISED -> EXISTS ON THE CLASS -> INDEPENDENT
 *      - E.G setAnimalCount(), Math.random() etc..., System.out.println()
 * - WHAT IS HAPPENING ON LINES 15 - 21?
 *  - INITIALIZATION BLOCK -> CONSTRUCTOR FOR A STATIC FIELD
 * - WHY IS getRandomName() PRIVATE?
 *  - THE METHOD IS ONLY USED IN THIS CLASS -> DOESN'T MAKE SENSE TO BE PUBLIC
 *  - ENCAPSULATION
 * - IN MAIN GET A ANIMAL AT INDEX 0
 */

public class Zoo{

    private static final List<Animal> zoo = new ArrayList<>();

    // SETUP -> ANIMALS IN OUR ZOO
    static {
        // INSIDE HERE WILL RUN ONCE
        // LOOP
        for (int i = 0; i < 5; i++) {
            // ADD A Magpie, Lion TO OUR ZOO
            // PASSING IN A RANDOM NAME TO EACH Animal
            String magpieName = getRandomName();
            zoo.add(new Magpie(magpieName));
            zoo.add(new Lion(getRandomName()));
        }
    }

    public static List<Animal> getZoo(){
        return zoo;
    }

    private static String getRandomName() {
        String[] names = {"Aiman",
                "Ali",
                "Fernanda",
                "Gavin",
                "Hassan",
                "Hugo",
                "Isobelle",
                "Mark",
                "Mohammad",
                "Rachel",
                "Samuel",
                "Wesley",
                "Will",};

        int random = (int) (Math.random() * names.length);
        return names[random];
    }

    public static Animal getAnimalByIndex(int index) {
        return zoo.get(index);
    }

}
