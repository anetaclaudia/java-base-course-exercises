package ee.taltech.iti0200.kt1.chocolatefactory;

import java.util.Arrays;

public class ChocolateFactory {
    private int chocolateBoxesMade;
    private int costSoFar;

    public enum BoxType {

        SQUARE1(4, 4),
        SQUARE2(5, 5),
        RECTANGLE1(3, 6),
        RECTANGLE2(4, 8);

        private int width;
        private int length;

        BoxType(int width, int length) {
            this.width = width;
            this.length = length;
        }
    }

    public ChocolateType[][] makeChocolateBox(ChocolateType chocolate1, ChocolateType chocolate2,
                                              Integer preferredChocolate1Count, BoxType boxType) {
        ChocolateType[][] array = new ChocolateType[boxType.length][boxType.width];
        int boxCircumference = (boxType.length * 2) + ((boxType.width - 2) * 2);
        this.chocolateBoxesMade += 1;
        if (preferredChocolate1Count == 0) {
            this.costSoFar += chocolate2.price * (boxType.length * boxType.width);
            return zeroBox(array, chocolate2);
        } else if (preferredChocolate1Count == 4 || preferredChocolate1Count == boxCircumference) {
            boolean isCircumference = false;
            if (preferredChocolate1Count == boxCircumference) {
                isCircumference = true;
            }
            return fourCircumferenceBox(array, chocolate1, chocolate2, isCircumference);
        }
        return chessBox(array, chocolate1, chocolate2);
    }

    private ChocolateType[][] zeroBox(ChocolateType[][] array, ChocolateType chocolate2) {
        for (ChocolateType[] chocolateTypes : array) {
            Arrays.fill(chocolateTypes, chocolate2);
        }
        return array;
    }

    private ChocolateType[][] fourCircumferenceBox(ChocolateType[][] array, ChocolateType chocolate1,
                                                   ChocolateType chocolate2, boolean isCircumference) {
        int chocOneCount = 0;
        int chocTwoCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || i == array.length - 1) {
                if (isCircumference) {
                    Arrays.fill(array[i], chocolate1);
                    chocOneCount += array[i].length;
                } else {
                    Arrays.fill(array[i], chocolate2);
                    array[i][0] = chocolate1;
                    array[i][array[i].length - 1] = chocolate1;
                    chocTwoCount += array[i].length - 2;
                    chocOneCount += 2;
                }
            } else {
                if (isCircumference) {
                    Arrays.fill(array[i], chocolate2);
                    array[i][0] = chocolate1;
                    array[i][array[i].length - 1] = chocolate1;
                    chocTwoCount += array[i].length - 2;
                    chocOneCount += 2;
                } else {
                    Arrays.fill(array[i], chocolate2);
                    chocTwoCount += array[i].length;
                }
            }
        }
        this.costSoFar += chocOneCount * chocolate1.price + chocTwoCount * chocolate2.price;
        return array;
    }

    private ChocolateType[][] chessBox(ChocolateType[][] array, ChocolateType chocolate1,
                                       ChocolateType chocolate2) {
        boolean chocOne = true;
        int chocOneCount = 0;
        int chocTwoCount = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (chocOne) {
                    array[i][j] = chocolate1;
                    chocOneCount++;
                } else {
                    array[i][j] = chocolate2;
                    chocTwoCount++;
                }
                chocOne = !chocOne;
            }
            if (array[i].length % 2 == 0) {
                chocOne = !chocOne;
            }
        }
        this.costSoFar += chocOneCount * chocolate1.price + chocTwoCount * chocolate2.price;
        return array;
    }

    public int getChocolateBoxesMade() {
        return chocolateBoxesMade;
    }

    public int getCostSoFar() {
        return costSoFar;
    }

//    public static void main(String[] args) {
//        ChocolateFactory factory = new ChocolateFactory();
//        ChocolateType[][] a = factory.makeChocolateBox(new ChocolateType(7, "0"),
//                new ChocolateType(9, "o"), 20, BoxType.RECTANGLE2);
//        System.out.println(factory.getCostSoFar());
//        System.out.println(factory.getChocolateBoxesMade());
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[i].length; j++) {
//                System.out.print(a[i][j].getStringForm());
//            }
//            System.out.println();
//        }
//    }
}
