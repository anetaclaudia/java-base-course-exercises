package ee.taltech.iti0200.tk1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam {

    /**
     * Return the sum of the numbers in the array,
     * except ignore sections of numbers
     * starting with a 6 and extending to the next 7
     * (every 6 will be followed by at least one 7).
     * Return 0 for no numbers.
     * <p>
     * sum67([1, 2, 2]) => 5
     * sum67([1, 2, 2, 6, 99, 99, 7]) => 5
     * sum67([1, 1, 6, 7, 2]) => 4
     */
    public static int sum67(List<Integer> numbers) {
        int result = 0;
        boolean isAdding = true;
        for (Integer number : numbers) {
            if (number == 6) {
                isAdding = false;
            } else if (number == 7) {
                isAdding = true;
            } else if (isAdding) {
                result += number;
            }
        }
        return result;
    }

    /**
     * Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields "bca".
     * Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group of fewer than 3 chars at the end.
     * <p>
     * oneTwo("abc") => "bca"
     * oneTwo("tca") => "cat"
     * oneTwo("tcagdo") => "catdog"
     */
    public static String oneTwo(String str) {
        String result = "";
        for (int i = 0; i < str.length() - 2; i += 3) {
            result = result + str.substring(i + 1, i + 3) + str.charAt(i);
        }
        return result;
    }

    /**
     * Modify and return the given map as follows:
     * if exactly one of the keys "a" or "b" exists in the map (but not both), set the other to have that same value in the map.
     * <p>
     * mapAXorB({"a": "aaa", "c": "cake"}) => {"a": "aaa", "b": "aaa", "c": "cake"}
     * mapAXorB({"b": "bbb", "c": "cake"}) => {"a": "bbb", "b": "bbb", "c": "cake"}
     * mapAXorB({"a": "aaa", "b": "bbb", "c": "cake"}) => {"a": "aaa", "b": "bbb", "c": "cake"}
     */
    public static Map<String, String> mapAXorB(Map<String, String> map) {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry mapEntry : map.entrySet()) {
            // if (mapEntry.getKey().equals("a"))
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(sum67(List.of(1, 2, 2))); // 5
        System.out.println(sum67(List.of(1, 2, 2, 6, 99, 99, 7))); // 5
        System.out.println(sum67(List.of(1, 1, 6, 7, 2))); // 4
        System.out.println(oneTwo("abc"));
        System.out.println(oneTwo("tca"));
        System.out.println(oneTwo("tcagdo"));
    }
}
