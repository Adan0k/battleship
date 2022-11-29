import java.util.*;

public class Letters {
    private static ArrayList<String> letters = new ArrayList<>(List.of(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}));

    static int toNumber(String letter){
        return letters.indexOf(letter);
    }
    static boolean containsLetter(String letter){
        return letters.contains(letter);
    }
}
