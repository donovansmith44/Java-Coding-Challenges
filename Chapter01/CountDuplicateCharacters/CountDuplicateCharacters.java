import java.util.*;
import java.util.stream.Collectors;
import java.util.function.*;

public class CountDuplicateCharacters {
    public static void main(String[] args) {
        System.out.println(countDuplicateCharacters("Donovan Smith"));
        System.out.println(countDuplicateCharactersV2("Donovan Smith"));
    }

    public static Map<Character, Long> countDuplicateCharacters(String s) {
        Map<Character, Long> result = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return result;
    }

    public static Map<Character, Integer> countDuplicateCharactersV2(String s) {
        Map<Character, Integer> result = new HashMap<>();

        for (char c : s.toCharArray()) {
            result.compute(c, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }
}
