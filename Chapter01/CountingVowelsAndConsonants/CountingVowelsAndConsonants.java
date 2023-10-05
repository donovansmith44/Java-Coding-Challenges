import java.util.*;
import java.util.Arrays;
import java.lang.Character;
import java.util.stream.Stream;

public class CountingVowelsAndConsonants {
    public static void main(String[] args) {
        countVowelsAndConsonants("Donovan");
        countVowelsAndConsonants("Donovan!!!1428141");
        countVowelsAndConsonants("kkfdajfa");
    }

    public static void countVowelsAndConsonants(String str) {
        List<Character> vowels = new ArrayList<Character>();
        vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        long numVowels = str.chars().mapToObj(c -> (char) c).filter(c -> vowels.contains(c)).count();
        long numConsonants = str.chars().mapToObj(c -> (char) c)
                .filter(c -> !vowels.contains(c) && c >= 'A' && c <= 'z').count();

        System.out.println("Number of consontants in " + str + ": " + numConsonants);
        System.out.println("Number of vowels in " + str + ": " + numVowels);
    }
}
