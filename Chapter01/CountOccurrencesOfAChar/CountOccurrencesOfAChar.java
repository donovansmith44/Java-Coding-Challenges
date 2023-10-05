import java.util.*;
import java.util.function.Function;

public class CountOccurrencesOfAChar {
    public static void main(String[] args) {
        String test1 = "Donovan";
        String test2 = "Watermelon";
        String test3 = "Emacs";

        System.out.println(occurrencesOfChar(test1, 'n'));
        System.out.println(occurrencesOfChar(test2, 'z'));
        System.out.println(occurrencesOfChar(test3, 'E'));
        System.out.println(occurrencesOfCharV2(test1, 'n'));
        System.out.println(occurrencesOfCharV2(test2, 'z'));
        System.out.println(occurrencesOfCharV2(test3, 'E'));
    }

    static long occurrencesOfChar(String str, char ch) {
        long result = str.chars().mapToObj(c -> (char) c).filter(c -> c == ch).count();
        return result;
    }

    static int occurrencesOfCharV2(String str, char ch) {
        int result = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                result++;
            }
        }

        return result;
    }
}
