package ee.taltech.iti0200.singleton;

import java.util.Set;

public class UnicornObserver {
    public static final int MAX_UNICORN_SIZE = 16;
    private String name;
    private int skill;

    public UnicornObserver(String name, int skill) {
        this.name = name;
        this.skill = skill;
    }

    void observe(Unicorn unicorn) {
        if (this.skill >= 1 && unicorn.getSize().equals(Unicorn.Size.LARGE)) {
            UnicornRegistry.getInstance().registerUnicorn(unicorn, this);
        } else if (this.skill >= 4 && unicorn.getSize().equals(Unicorn.Size.MEDIUM)) {
            UnicornRegistry.getInstance().registerUnicorn(unicorn, this);
        } else if (this.skill >= 10 && unicorn.getSize().equals(Unicorn.Size.SMALL)) {
            UnicornRegistry.getInstance().registerUnicorn(unicorn, this);
        } else if (this.skill >= MAX_UNICORN_SIZE && unicorn.getSize().equals(Unicorn.Size.TINY)) {
            UnicornRegistry.getInstance().registerUnicorn(unicorn, this);
        }
    }

    public String brag() {
        Set<Unicorn> unicorns = UnicornRegistry.getInstance().getUnicornsDiscoveredBy(this);
        Unicorn rarestUnicorn = null;
        int rarestIndex = -1;
        if (unicorns.isEmpty()) {
            return "Sadly I have not discovered any unicorns.";
        }
        for (Unicorn unicorn : unicorns) {
            if (rarestIndex < 0) {
                rarestIndex = UnicornRegistry.getInstance().getUnicornRarityIndex(unicorn);
                rarestUnicorn = unicorn;
            } else {
                int currentIndex = UnicornRegistry.getInstance().getUnicornRarityIndex(unicorn);
                if (currentIndex < rarestIndex) {
                    rarestIndex = currentIndex;
                    rarestUnicorn = unicorn;
                }
                if (rarestIndex == 1) {
                    break;
                }
            }
        }
        if (rarestIndex == 1) {
            return String.format("I discovered a %s %s unicorn at %s and it is the rares unicorn.",
                    rarestUnicorn.getColor(), rarestUnicorn.getSize(), rarestUnicorn.getLocation());
        } else {
            return String.format("I discovered a %s %s unicorn at %s.",
                    rarestUnicorn.getColor(), rarestUnicorn.getSize(), rarestUnicorn.getLocation());
        }
    }
}
