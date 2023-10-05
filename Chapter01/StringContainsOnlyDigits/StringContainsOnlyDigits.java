import java.util.*;

public class StringContainsOnlyDigits {
    public static void main(String[] args) {
        System.out.println(containsOnlyDigits("1234567890"));
        System.out.println(containsOnlyDigits("123456789a"));
    }

    static boolean containsOnlyDigits(String str) {
        return str.chars().mapToObj(c -> (char) c).allMatch(c -> Character.isDigit(c));
    }
}
