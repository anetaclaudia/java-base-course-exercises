package ee.taltech.iti0200.generics;

import ee.taltech.iti0200.generics.cats.PersianCat;
import ee.taltech.iti0200.generics.dogs.DobermanDog;
import ee.taltech.iti0200.generics.foods.Food;
import ee.taltech.iti0200.generics.foods.Meat;

import java.util.Optional;

public class AnimalBox<T extends Animal> {
    private T animal;

    public void put(T t) {
        this.animal = t;
    }

    public void sound() {
        if (animal != null) {
            animal.sound();
        }
    }

    public <T extends Food> void feed(T food) {
        if (animal != null) {
            System.out.println(String.format("%s was fed with %s", animal.name, food.getName()));
        }
    }

    public Optional<T> getAnimal() {
        if (animal != null) {
            return Optional.of(animal);
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        // Cat
        AnimalBox<PersianCat> persianCatAnimalBox = new AnimalBox();
        PersianCat persianCat = new PersianCat("Elf");
        persianCatAnimalBox.put(persianCat);

        Optional<PersianCat> catFromBox = persianCatAnimalBox.getAnimal();
        System.out.println(catFromBox.isPresent()); // true
        System.out.println(persianCat.equals(catFromBox.get())); // true

        persianCatAnimalBox.sound(); // Prrr-prrr

        // Dog
        AnimalBox<DobermanDog> dogAnimalBox = new AnimalBox();

        DobermanDog dobby = new DobermanDog("Dobby");
        dogAnimalBox.put(dobby);

        dogAnimalBox.sound(); // Woof!

        // Food
        Food meat = new Meat();
        persianCatAnimalBox.feed(meat); // Elf was fed with MEAT
    }
}
