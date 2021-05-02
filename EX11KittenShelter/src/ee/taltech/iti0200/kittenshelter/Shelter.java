package ee.taltech.iti0200.kittenshelter;

import ee.taltech.iti0200.kittenshelter.kitten.Colour;
import ee.taltech.iti0200.kittenshelter.kitten.Kitten;
import ee.taltech.iti0200.kittenshelter.procedures.Chip;
import ee.taltech.iti0200.kittenshelter.procedures.Neuter;
import ee.taltech.iti0200.kittenshelter.procedures.Procedure;
import ee.taltech.iti0200.kittenshelter.procedures.Vaccinate;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Shelter {
    String name;
    int maxKittenAmount;
    int budget;
    int adoptionFee;
    Set<Kitten> kittens = new HashSet<>();


    public Shelter(String name, int maxKittenAmount, int budget, int adoptionFee) {
        this.name = name;
        this.maxKittenAmount = maxKittenAmount;
        this.budget = budget;
        this.adoptionFee = adoptionFee;
    }

    public Set<Kitten> getKittens() {
        return kittens;
    }

    public int getBudget() {
        return budget;
    }

    public void addKitten(Kitten kitten) {
        if (kittens.size() <= maxKittenAmount) {
            kittens.add(kitten);
        }
    }

    public Set<Kitten> getKittensByColour(Colour colour) {
        return kittens.stream()
                .filter(kitten -> kitten.getColour().equals(colour))
                .collect(Collectors.toSet());
    }

    public Set<Kitten> getKittensWhoGetAlongWithOthers() {
        return kittens.stream()
                .filter(Kitten::getsAlongWithOthers)
                .collect(Collectors.toSet());
    }

    public boolean kittensProceduresAreDone(Kitten kitten) {
        return kitten.isChipped() && kitten.isNeutered() && kitten.isVaccinated();
    }

    public boolean canAdopt(Person person, Kitten kitten, Colour colour) {
        if ((person.getBudget() >= adoptionFee)
                && !(kitten.isQuarantined())
                && getKittensByColour(colour).contains(kitten)
                && ((person.getCatsOwned().size() > 0 && getKittensWhoGetAlongWithOthers().contains(kitten))
                || (person.getCatsOwned().size() == 0))
                && kittensProceduresAreDone(kitten)) {
            budget = budget + adoptionFee;
            person.setBudget(person.getBudget() - adoptionFee);
            person.addKitten(kitten);
            kittens.remove(kitten);
            return true;
        }
        return false;
    }

    public void toProcedure(Procedure procedure, Kitten kitten) {
        if (procedure.getPrice() <= budget) {
            if (procedure.getClass().equals(Neuter.class)) {
                kitten.setNeutered(true);
            } else if (procedure.getClass().equals(Chip.class)) {
                kitten.setChipped(true);
            } else if (procedure.getClass().equals(Vaccinate.class)) {
                kitten.setVaccinated(true);
            }
            budget = budget - procedure.getPrice();
        }
    }

}
