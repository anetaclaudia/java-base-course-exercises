package ee.taltech.iti0200.kittenshelter.kitten;

public class Kitten {
    private String name;
    private Gender gender;
    private Colour colour;
    boolean getsAlongWithOthers;
    boolean isQuarantined;
    boolean isNeutered;
    boolean isChipped;
    boolean isVaccinated;

    public Kitten(String name, Gender gender, Colour colour, boolean getsAlongWithOthers) {
        this.name = name;
        this.gender = gender;
        this.colour = colour;
        this.getsAlongWithOthers = getsAlongWithOthers;
    }


    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Colour getColour() {
        return colour;
    }

    public boolean getsAlongWithOthers() {
        return getsAlongWithOthers;
    }

    public boolean isQuarantined() {
        return isQuarantined;
    }

    public void setQuarantined(boolean quarantined) {
        isQuarantined = quarantined;
    }

    public boolean isNeutered() {
        return isNeutered;
    }

    public void setNeutered(boolean neutered) {
        isNeutered = neutered;
    }

    public boolean isChipped() {
        return isChipped;
    }

    public void setChipped(boolean chipped) {
        isChipped = chipped;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }
}
