package ee.taltech.iti0200.kt0;

import java.util.List;

public class Exam {

    /**
     * Given lists nums1 and nums2 of the same length,
     * for every element in nums1, consider the corresponding
     * element in nums2 (at the same index).
     * Return the count of the number of times
     * that the two elements differ by 2 or less, but are not equal.
     * <p>
     * matchUp([1, 2, 3], [2, 3, 10]) => 2
     * matchUp([1, 2, 3], [2, 3, 5]) => 3
     * matchUp([1, 2, 3], [2, 3, 3]) => 2
     */
    public static int matchUp(List<Integer> a, List<Integer> b) {
        int result = 0;
        for (int i = 0; i < a.size(); i++) {
            int difference = Math.abs(a.get(i) - b.get(i));
            if (0 < difference && difference <= 2) {
                result++;
            }
        }
        return result;
    }

    /**
     * Given two strings, word and a separator sep,
     * return a big string made of count occurrences of the word,
     * separated by the separator string.
     * <p>
     * repeatSeparator("Word", "X", 3) => "WordXWordXWord"
     * repeatSeparator("This", "And", 2) => "ThisAndThis"
     * repeatSeparator("This", "And", 1) => "This"
     */
    public static String repeatSeparator(String word, String sep, int count) {
        StringBuilder result = new StringBuilder();
        int addedCount = 1;
        if (count == 1) {
            result.append(word);
        } else {
            for (int i = 0; i < count; i++) {
                if (addedCount < count) {
                    result.append(word).append(sep);
                    addedCount++;
                }
                if (addedCount == count) {
                    result.append(word);
                    addedCount++;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        List<Integer> testA = List.of(1, 2, 3);
        List<Integer> testB = List.of(2, 3, 10);
        List<Integer> testC = List.of(2, 3, 5);
        List<Integer> testD = List.of(2, 3, 3);

        System.out.println(matchUp(testA, testB)); // 2
        System.out.println(matchUp(testA, testC)); // 3
        System.out.println(matchUp(testA, testD)); // 2

        System.out.println(repeatSeparator("Word", "X", 3)); //"WordXWordXWord"
        System.out.println(repeatSeparator("This", "And", 2)); //"ThisAndThis"
        System.out.println(repeatSeparator("This", "And", 1)); //"This"
    }

}
