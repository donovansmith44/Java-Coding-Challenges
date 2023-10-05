import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.Collections;

public class ReversingLettersAndWords {
    public static void main(String[] args) {
        List<String> test = new ArrayList<String>();
        test.addAll(Arrays.asList("Donovan", "Turner", "Smith", "is", "writing", "code"));
        System.out.println(reverseLetters(test));
        System.out.println(reverseLettersAndWords(test));
    }

    public static List<String> reverseLetters(List<String> words) {
        List<String> result = new ArrayList<String>(words);

        result = result.stream().map(s -> new StringBuilder(s).reverse().toString()).collect(Collectors.toList());
        return result;
    }

    public static List<String> reverseLettersAndWords(List<String> words) {
        Collections.reverse(words);
        List<String> reversedLettersAndWords = reverseLetters(words);
        return reversedLettersAndWords;
    }
}
