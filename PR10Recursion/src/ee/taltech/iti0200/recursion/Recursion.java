package ee.taltech.iti0200.recursion;

import ee.taltech.iti0200.recursion.mlp.MyLittlePony;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {

    public static List<String> eliminatePonies(List<MyLittlePony> ponies, List<String> ponyNames, Integer listIndex) {

        if (ponies.size() == 0) {
            return new ArrayList<>();
        }
        if (ponies.size() == 1) {
            ponyNames.add(ponies.get(listIndex).getName());
            return List.of(ponies.get(0).getName());
        }
        if ((listIndex + 1) < ponies.size()) {
            if (!(ponies.get(listIndex).getPonyType().equals(ponies.get(listIndex + 1).getPonyType()))) {
                ponyNames.add(ponies.get(listIndex).getName());
            }
            ponies = ponies.subList(1, ponies.size());
        }

        eliminatePonies(ponies, ponyNames, 0);

        return ponyNames;
    }

    public static int getPonyNamesLengthProduct(List<MyLittlePony> ponies, int product) {
        if (ponies.size() == 0) {
            product = 0;
            return product;
        }
        if (ponies.size() == 1) {
            product += ponies.get(0).getName().length();
            return product;
        } else {
            product += ponies.get(0).getName().length();
            ponies = ponies.subList(1, ponies.size());
        }
        return getPonyNamesLengthProduct(ponies, product);
    }


    public static int getPonyNamesLengthProductExceptType(List<MyLittlePony> ponies,
                                                          int product,
                                                          MyLittlePony.PonyType type) {

        if (ponies.size() == 0) {
            product = 0;
            return product;
        }
        if (ponies.size() == 1) {
            if (!(ponies.get(0).getPonyType().equals(type))) {
                product += ponies.get(0).getName().length();
            }
            return product;
        } else {
            if (!(ponies.get(0).getPonyType().equals(type))) {
                product += ponies.get(0).getName().length();
            }
            ponies = ponies.subList(1, ponies.size());
        }
        return getPonyNamesLengthProductExceptType(ponies, product, type);
    }

    public static void main(String[] args) {
        MyLittlePony fluttershy = new MyLittlePony("Fluttershy", MyLittlePony.PonyType.PEGASUS);
        MyLittlePony rainbowDash = new MyLittlePony("Rainbow Dash", MyLittlePony.PonyType.PEGASUS);
        MyLittlePony rainbowDash2 = new MyLittlePony("Rainbow Dash2", MyLittlePony.PonyType.PEGASUS);
        MyLittlePony rarity = new MyLittlePony("Rarity", MyLittlePony.PonyType.UNICORN);
        MyLittlePony applejack = new MyLittlePony("Applejack", MyLittlePony.PonyType.EARTH_PONY);
        MyLittlePony pinkiePie = new MyLittlePony("Pinkie Pie", MyLittlePony.PonyType.EARTH_PONY);
        MyLittlePony pinkiePie2 = new MyLittlePony("Pinkie Pie2", MyLittlePony.PonyType.EARTH_PONY);
        List<MyLittlePony> myLittlePonyList = Arrays.asList(fluttershy, rainbowDash, rarity, applejack, pinkiePie);
        List<String> nameList = Arrays.asList("Fluttershy", "Rainbow Dash", "Rarity", "Applejack", "Pinkie Pie");
        List<String> nameList2 = new ArrayList<>();

//        List<String> y = eliminatePonies(myLittlePonyList, nameList2, 0); // [Rainbow Dash, Rarity, Pinkie Pie].
//        System.out.println(y);

//        System.out.println(getPonyNamesLengthProduct(myLittlePonyList, 0));
        System.out.println(getPonyNamesLengthProductExceptType(myLittlePonyList, 0, MyLittlePony.PonyType.UNICORN));
    }

}
