import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;

public class FindFirstNonRepeatedCharacter {
    public static void main(String[] args) {
        char c1 = Solution.firstNonRepeatedCharacter("Donovan");
        System.out.println(c1);

        char c2 = Solution.firstNonRepeatedCharacterV2("aaaaaaaaaabb");
        System.out.println(c2);
    }
}

class Solution {
    private static final int EXTENDED_ASCII_CODES = 256;

    public static char firstNonRepeatedCharacter(String s) {
        int[] flags = new int[EXTENDED_ASCII_CODES];

        Arrays.fill(flags, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (flags[c] == -1) {
                flags[c] = i;
            } else {
                flags[c] = -2;
            }
        }

        int position = Integer.MAX_VALUE;

        for (int i = 0; i < EXTENDED_ASCII_CODES; i++) {
            if (flags[i] >= 0) {
                position = Math.min(position, flags[i]);
            }
        }
        return position == Integer.MAX_VALUE ? Character.MIN_VALUE : s.charAt(position);
    }

    public static char firstNonRepeatedCharacterV2(String s) {
        Map<Character, Integer> chars = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            chars.compute(c, (k, v) -> (v == null) ? 1 : ++v);
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }

    public static String firstNonRepeatedCharacterV3(String s) {

        Map<Integer, Long> chs = s.codePoints().mapToObj(cp -> cp)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        /*
         * We get the entrySet, filter entries for those which have a value of 1, find
         * the first one, and if the first thing is null, then return the
         * Character.MIN_VALUE
         */
        int cp = chs.entrySet().stream().filter(e -> e.getValue() == 1L).findFirst().map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));

        return String.valueOf(Character.toChars(cp));
    }
}
