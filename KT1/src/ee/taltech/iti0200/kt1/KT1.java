package ee.taltech.iti0200.kt1;

import java.util.HashMap;
import java.util.Map;

public class KT1 {
    /**
     * Given a non-empty array of integers,
     * every element appears twice except for one. Find that single one.
     * If there are not such (and in any other case) return 0.
     * <p>
     * singleNumber([2,2,1]) => 1
     * singleNumber([4,1,2,1,2]) => 4
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> numsOccurrence = new HashMap<>();
        int result = 0;

        for (int num : nums) {
            if (!(numsOccurrence.containsKey(num))) {
                numsOccurrence.put(num, 1);
            } else {
                numsOccurrence.put(num, numsOccurrence.get(num) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : numsOccurrence.entrySet()) {
            if (entry.getValue() == 1) {
                result += entry.getKey();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] testA = new int[]{2, 2, 1};
        int[] testB = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(testA)); //1
        System.out.println(singleNumber(testB)); //4
    }
}
