package ee.taltech.iti0200.sum100;

import java.util.ArrayList;
import java.util.List;

public class Sum100 {
    public static List<String> calcSums(List<MagicNumber> input) {
        List<String> output = new ArrayList<>();
        return calcSumsAssistant(input, output, "", 0, 0);
    }

    public static List<String> calcSumsAssistant(List<MagicNumber> input,
                                                 List<String> output,
                                                 String toAdd,
                                                 int sumOfString,
                                                 int loc) {
        if (loc > input.size() - 1) {
            if (toAdd.startsWith("+")) {
                toAdd = toAdd.substring(1);
            }
            if (sumOfString == 100) {
                output.add(toAdd);
            }
            return output;
        }
        calcSumsAssistant(input,
                output,
                toAdd + "+" + Integer.toString(input.get(loc).getNumber()),
                sumOfString + input.get(loc).getNumber(),
                loc + 1);
        if (input.get(loc).canBeSubtracted()) {
            calcSumsAssistant(input,
                    output,
                    toAdd + "-" + Integer.toString(input.get(loc).getNumber()),
                    sumOfString - input.get(loc).getNumber(),
                    loc + 1);
        }
        if (loc + 1 < input.size()) {
            if (input.get(loc).canBePlacedNextToOther()
                    && input.get(loc + 1).canBePlacedNextToOther()) {
                String numbersTogether = Integer.toString(input.get(loc).getNumber())
                        + Integer.toString(input.get(loc + 1).getNumber());
                if (input.get(loc).canBeSubtracted() && input.get(loc + 1).canBeSubtracted()) {
                    calcSumsAssistant(input,
                            output,
                            toAdd + "-" + numbersTogether,
                            sumOfString - Integer.parseInt(numbersTogether),
                            loc + 2);
                }
                calcSumsAssistant(input,
                        output,
                        toAdd + "+" + numbersTogether,
                        sumOfString + Integer.parseInt(numbersTogether),
                        loc + 2);

            }
        }
        if (loc + 2 < input.size()) {
            if (input.get(loc).canBePlacedNextToOther()
                    && input.get(loc + 1).canBePlacedNextToOther()
                    && input.get(loc + 2).canBePlacedNextToOther()) {
                String numbersTogether = Integer.toString(input.get(loc).getNumber())
                        + Integer.toString(input.get(loc + 1).getNumber())
                        + Integer.toString(input.get(loc + 2).getNumber());
                if (input.get(loc).canBeSubtracted()
                        && input.get(loc + 1).canBeSubtracted()
                        && input.get(loc + 2).canBeSubtracted()) {
                    calcSumsAssistant(input,
                            output,
                            toAdd + "-" + numbersTogether,
                            sumOfString - Integer.parseInt(numbersTogether),
                            loc + 3);
                }
                calcSumsAssistant(input,
                        output,
                        toAdd + "+" + numbersTogether,
                        sumOfString + Integer.parseInt(numbersTogether),
                        loc + 3);

            }

        }
        return output;
    }

//    public static void main(String[] args) {
//        List<MagicNumber> testInput = Arrays.asList(
//                new TestNumber((short) 1, true, true),
//                new TestNumber((short) 2, true, true),
//                new TestNumber((short) 3, true, true),
//                new TestNumber((short) 4, true, true),
//                new TestNumber((short) 5, true, true),
//                new TestNumber((short) 6, true, true),
//                new TestNumber((short) 7, true, true),
//                new TestNumber((short) 8, true, true),
//                new TestNumber((short) 9, true, true));
//        List<String> x = calcSums(testInput);
//        System.out.println(x.size());
//        System.out.println(x);

//        1+2+3-4+5+6+78+9 = 100
//        1+2+34-5+67-8+9 = 100
//        1+23-4+5+6+78-9 = 100
//        1+23-4+56+7+8+9 = 100
//        -1+2-3+4+5+6+78+9 = 100
//        12+3+4+5-6-7+89 = 100
//        12+3-4+5+67+8+9 = 100
//        12-3-4+5-6+7+89 = 100
//        123+4-5+67-89 = 100
//        123-4-5-6-7+8-9 = 100
//        123+45-67+8-9 = 100
//        123-45-67+89 = 100
//    }
}
