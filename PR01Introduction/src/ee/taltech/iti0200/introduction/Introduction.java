package ee.taltech.iti0200.introduction;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Character.isUpperCase;

public class Introduction {


    /**
     * Method gets a string that contains x words.
     * The first character of the string starts a new word, next words always start with a capital letter.
     * Words are not separated by whitespace.
     * Words (including the first character) can contain all kinds of symbols.
     * The function should find and return x.
     *
     * @param string Given string that contains x words.
     * @return The number of words in the given string.
     */
    public int camelCaseWordCounter(String string) {
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (i == 0) {
                counter++;
            } else if (isUpperCase(string.charAt(i))) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Method gets a list of numbers.
     * Return a list containing only even numbers of the given list.
     * If the given list does not contain any even numbers, return an empty list.
     *
     * @param numbers given list that contains numbers.
     * @return list of even numbers.
     */
    public List<Integer> findEvenNumbersList(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                result.add(number);
            }
        }
        return result;
    }

    /**
     * Method gets an array of numbers.
     * Return an array containing only even numbers of the given array.
     * If the given array does not contain any even numbers, return an empty array.
     * <p>
     * You must not use the previous function in this function!
     *
     * @param numbers given array that contains numbers.
     * @return array of even numbers.
     */
    public int[] findEvenNumbersArray(int[] numbers) {
        int[] result = new int[numbers.length];
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                result[counter] = numbers[i];
                counter++;
            }
        }
        return Arrays.copyOf(result, counter);
    }

    public static void main(String[] args) {
        Introduction introduction = new Introduction();
        System.out.println(introduction.camelCaseWordCounter("KO4K43")); // 3

        List<Integer> nums = new ArrayList<>(Arrays.asList(4, 7, 5, 2, 1, 2, -2, 0));
        System.out.println(introduction.findEvenNumbersList(nums)); // [4, 2, 2, -2, 0]

        int[] array = {9, 0, 24, -6, 3};
        System.out.println(Arrays.toString(introduction.findEvenNumbersArray(array))); // [0, 24, -6]

        int u = 13;
        for (int i = u / 2; i++ < 12; i += 2) {
            u += --i;
        }
        System.out.println(u);
    }
}
