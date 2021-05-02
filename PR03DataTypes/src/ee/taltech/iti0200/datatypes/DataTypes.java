
package ee.taltech.iti0200.datatypes;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DataTypes {

    /**
     * Find all elements that appear more than once over all lists.
     * ["this", "is", "fun", "this", "is", "rad"], ["actually", "it", "is", "not", "fun"] ===>
     * ====> ["this", "is", "fun"]
     *
     * @param data List of lists containing strings
     * @return Set of unique data
     */
    public static Set<String> getUniqueDuplicates(List<List<String>> data) {
        Set<String> result = new HashSet<>();

        List<String> flatData = data.stream().flatMap(List::stream).collect(Collectors.toList());

        Map<String, Integer> count = new LinkedHashMap<>(); // create map from list to check the word frequency
        for (String word : flatData) {
            if (!count.containsKey(word)) {
                count.put(word, Collections.frequency(flatData, word));
            }
        }

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    /**
     * Calculate B^P mod M using BigInteger data type.
     * <p>
     * B = b!, P = p!, M = m!
     * n! = 1 * 2 * ... * (n-2) * (n-1) * n
     *
     * @return Algorithm value using BigInteger
     */
    public static BigInteger bigMod(int b, int p, int m) {
        BigInteger bFactorial = factorial(b);
        BigInteger pFactorial = factorial(p);
        BigInteger mFactorial = factorial(m);
        return bFactorial.modPow(pFactorial, mFactorial);
    }

    /**
     * Calculate factorial of a number also known as a!
     *
     * @param a
     * @return factorial of param
     */
    public static BigInteger factorial(int a) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= a; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * Convert different currencies to euros and return the sum it.
     * <p>
     * Map of CurrencyToEurRate always contains necessary exchange rates.
     *
     * @param data              Map containing the name of currency and a list of different values
     * @param currencyToEurRate Map containing the name of currency and its exchange rate to euro
     * @return Sum of money in euros
     */
    public static BigDecimal currencyConverter(Map<String, List<BigDecimal>> data, Map<String, BigDecimal>
            currencyToEurRate) {
        BigDecimal result = BigDecimal.ZERO;
        for (Map.Entry<String, List<BigDecimal>> entry : data.entrySet()) {
            BigDecimal currencyRate = currencyToEurRate.get(entry.getKey());
            for (BigDecimal dataEntry : entry.getValue()) {
                result = result.add(dataEntry.multiply(currencyRate));
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        List<String> data1 = new ArrayList<>(List.of("this", "is", "fun", "this", "is", "rad"));
//        List<String> data2 = new ArrayList<>(List.of("actually", "it", "is", "not", "fun"));
//        List<List<String>> data = new ArrayList<>(List.of(data1, data2));
//        System.out.println(getUniqueDuplicates(data)); // ["this", "is", "fun"]

//        System.out.println(factorial(3));

        System.out.println(bigMod(3, 5, 8)); // 3!^5! mod 8! = 26496

        Map<String, BigDecimal> currencyToEurRate = new HashMap<>();
        currencyToEurRate.put("Yen", BigDecimal.valueOf(0.00828172423484));
        currencyToEurRate.put("Pounds", BigDecimal.valueOf(1.17812423423082));

        Map<String, List<BigDecimal>> exchangeData = new HashMap<>();
        exchangeData.put("Yen", List.of(BigDecimal.valueOf(241645), BigDecimal.valueOf(321)));
        exchangeData.put("Pounds", List.of(BigDecimal.valueOf(256)));
        System.out.println(exchangeData.get("Yen"));

        System.out.println(exchangeData);
        System.out.println(currencyToEurRate);

        System.out.println(currencyConverter(exchangeData, currencyToEurRate)); //2305.49549017038536
    }
}
