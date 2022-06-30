import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * RESPONSIBLE FOR STORING & RETRIEVING ANIMALS
 */

public class Zoo{
    private static final List<Animal> zoo = new ArrayList<>();
    
    static {
        for (int i = 0; i < 2; i++) {
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

    public static List<Animal> sortAnimals(){
        // ZOO -> STREAM -> SORT IT -> COLLECT IT -> RETURN IT
        // DATA -> STREAM -> INTERMEDIATE ACTIONS -> TERMINAL ACTION ON IT
        // NOT MODIFYING THE ZOO NOW
        List<Animal> sortedZoo = zoo.stream()
                .sorted() // INTERMEDIATE ACTION -> DOING SOMETHING
                .collect(Collectors.toList()); // TERMINAL ACTION -> CLOSING STREAM GETTING A RESULT

        return sortedZoo;
    }

}
