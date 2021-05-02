package ee.taltech.iti0200.tk3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Exam {

    /**
     * For each multiple of 10 in the given array,
     * change all the values following it to be that multiple of 10,
     * until encountering another multiple of 10.
     * So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
     * <p>
     * tenRun([2, 10, 3, 4, 20, 5]) => [2, 10, 10, 10, 20, 20]
     * tenRun([10, 1, 20, 2]) => [10, 10, 20, 20]
     * tenRun([10, 1, 9, 20]) => [10, 10, 10, 20]
     */
    public static List<Integer> tenRun(List<Integer> nums) {
        int currentValueOfTen = -1;
        List<Integer> newNums = new ArrayList<>();
        for (Integer num : nums) {
            if (num % 10 == 0) {
                currentValueOfTen = num;
                newNums.add(num);
            } else if (currentValueOfTen % 10 == 0) {
                newNums.add(currentValueOfTen);
            } else {
                newNums.add(num);
            }
        }
        return newNums;
    }

    /**
     * Given three ints, a b c,
     * return true if one of b or c is "close" (differing from a by at most 1),
     * while the other is "far", differing from both other values by 2 or more.
     * <p>
     * closeFar(1, 2, 10) => true
     * closeFar(1, 2, 3) => false
     * closeFar(4, 1, 3) => true
     */
    public static boolean closeFar(int a, int b, int c) {
        if (Math.abs(a - b) <= 1 && Math.abs(a - c) >= 2) {
            return true;
        }
        if (Math.abs(a - b) >= 2 && Math.abs(a - c) <= 1) {
            return true;
        }
        return false;
    }

    /**
     * Return a version of the given string,
     * where for every star (*) in the string
     * the star and the chars immediately to its left and right are gone.
     * So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
     * <p>
     * starOut("ab*cd") => "ad"
     * starOut("ab**cd") => "ad"
     * starOut("sm*eilly") => "silly
     */
    public static String starOut(String str) {
        char[] chars = str.toCharArray();
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length()) {
                if (chars[i] == '*') {
                    if (chars[i + 1] == '*') {
                        i++;
                    }
                    i++;
                } else if (chars[i + 1] != '*') {
                    newString.append(chars[i]);
                }
                continue;
            }
            if (chars[i] == '*') {
                continue;
            }
            if (chars[i] != '*') {
                newString.append(chars[i]);
            }
        }
        return String.valueOf(newString);
    }

    /**
     * Modify and return the given map as follows:
     * if the keys "a" and "b" have values that have different lengths,
     * then set "c" to have the longer value.
     * If the values exist and have the same length,
     * change them both to the empty string in the map.
     * <p>
     * mapABLonger({"a": "aaa", "b": "bb", "c": "cake"}) => {"a": "aaa", "b": "bb", "c": "aaa"}
     * mapABLonger({"a": "aa", "b": "bbb", "c": "cake"}) => {"a": "aa", "b": "bbb", "c": "bbb"}
     * mapABLonger({"a": "aa", "b": "bbb"}) => {"a": "aa", "b": "bbb", "c": "bbb"}
     */
    public static Map<String, String> mapABLonger(Map<String, String> map) {
        if (map.containsKey("a") && map.containsKey("b")) {
            int difference = Math.abs(map.get("a").length() - map.get("b").length());
            if (difference > 0) {
                if (map.get("a").length() > map.get("b").length()) {
                    map.put("c", map.get("a"));
                } else if (map.get("b").length() > map.get("a").length()) {
                    map.put("c", map.get("b"));
                }
            } else {
                map.put("a", "");
                map.put("b", "");
            }
        }
        return map;
    }

    public static void main(String[] args) {
//        System.out.println(closeFar(1, 2, 10)); // true
//        System.out.println(closeFar(1, 2, 3)); // false
//        System.out.println(closeFar(4, 1, 3)); // true
//
//        System.out.println(tenRun(List.of(2, 10, 3, 4, 20, 5)));
//        System.out.println(tenRun(List.of(10, 1, 20, 2)));
//
//        System.out.println(starOut("ab*cd")); // ad
//        System.out.println(starOut("ab**cd")); // ad
//        System.out.println(starOut("sm*eilly")); // silly
//
//        Map<String, String> test1 = new HashMap<>();
//        test1.put("a", "aaa");
//        test1.put("b", "bb");
//        test1.put("c", "cake");
//
//        System.out.println(mapABLonger(test1));
    }
}
