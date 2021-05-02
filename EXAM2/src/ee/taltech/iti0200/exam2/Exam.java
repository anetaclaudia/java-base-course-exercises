package ee.taltech.iti0200.exam2;


public class Exam {

    /**
     * Write a recursive method which finds all the double and triple consecutive characters in the string.
     * Triple consecutive characters give 2 points.
     * Double consecutive characters give 1 point,
     * Sums all the combinations and returns the sum.
     * NB! Method must be recursive and not contain any for loops.  Helper functions  and are not allowed.
     * <p>
     * "abc" => 0
     * "aa" => 1
     * "aab" => 1
     * "aaa" => 2
     * "aaabb" => 3
     * "aaaaaa" => 4 (2 times triple 'a', NOT 3 times double 'a')
     * "" => 0
     */
    public static int recCount(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        if (s.length() >= 3) {
            String c = s.substring(0, 1);
            String chars = c + c + c;
            if (chars.equals(s.substring(0, 3))) {
                return 2 + recCount(s.substring(3));
            }
        }
        String c = s.substring(0, 1);
        String chars = c + c;
        if (!chars.equals(s.substring(0, 2))) {
            return recCount(s.substring(1));
        }
        return 1 + recCount(s.substring(2));
    }

    public static void main(String[] args) {
        System.out.println(recCount("abc")); // 0
        System.out.println(recCount("aa")); // 1
        System.out.println(recCount("aab")); // 1
        System.out.println(recCount("aaa")); // 2
        System.out.println(recCount("aaabb")); // 3
        System.out.println(recCount("aaaaaa")); // 4
    }
}

