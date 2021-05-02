package ee.taltech.iti0200.kittenshelter;

import ee.taltech.iti0200.kittenshelter.kitten.Kitten;

import java.util.HashSet;
import java.util.Set;

public class Person {
    private String name;
    private int budget;
    Set<Kitten> catsOwned = new HashSet<>();

    public Person(String name, int budget) {
        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Set<Kitten> getCatsOwned() {
        return catsOwned;
    }

    public void addKitten(Kitten kitten) {
        catsOwned.add(kitten);
    }

}
